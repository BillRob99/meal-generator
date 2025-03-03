package mealgenerator.service;

import mealgenerator.model.external.MealDbMeal;
import mealgenerator.model.internal.Ingredient;
import mealgenerator.model.internal.IngredientMeasurement;
import mealgenerator.model.internal.Meal;
import mealgenerator.model.internal.MealCategory;
import mealgenerator.proxy.MealDbProxy;
import mealgenerator.repository.CustomMealRepository;
import mealgenerator.repository.MealRepository;
import mealgenerator.transformer.Transformer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class MealServiceTest {

    @MockitoBean
    private MealDbProxy mealDbProxy;

    @MockitoBean
    private MealRepository mealRepository;

    @MockitoBean
    private CustomMealRepository customMealRepository;

    @Autowired
    private Transformer<MealDbMeal, Meal> mealDbTransformer;

    @Autowired
    private MealService mealService;

    @Test
    void testLoadMealsByCategory() {
        // Arrange
        List<MealDbMeal> mealDbMeals = createMealDbMeals();
        List<Meal> expectedMeals = createMeals();

        when(mealDbProxy.getMealsByCategory(MealCategory.CHICKEN)).thenReturn(mealDbMeals);
        when(mealRepository.saveAll(expectedMeals)).thenReturn(expectedMeals);

        // Act
        mealService.loadMealsByCategory(MealCategory.CHICKEN);

        // Assert
        verify(mealRepository, times(1)).deleteAllByCategory(MealCategory.CHICKEN.toString());
        verify(mealDbProxy, times(1)).getMealsByCategory(MealCategory.CHICKEN);
        verify(mealRepository, times(1)).saveAll(expectedMeals);
    }

    private static List<MealDbMeal> createMealDbMeals() {
        MealDbMeal mealDbMeal = new MealDbMeal();
        mealDbMeal.setIdMeal(123L);
        mealDbMeal.setStrMeal("Test Meal");
        mealDbMeal.setStrCategory("Chicken");
        mealDbMeal.setStrArea("Test Area");
        mealDbMeal.setStrInstructions("Test Instructions");
        mealDbMeal.setStrYoutube("http://youtube.com/test");
        mealDbMeal.setStrTags("tag1,tag2");
        mealDbMeal.setStrIngredient1("Ingredient1");
        mealDbMeal.setStrMeasure1("Measure1");

        return List.of(mealDbMeal);
    }

    private static List<Meal> createMeals() {
        Meal meal = new Meal();
        meal.setSourceId(123L);
        meal.setName("Test Meal");
        meal.setCategory(MealCategory.CHICKEN);
        meal.setArea("Test Area");
        meal.setInstructions("Test Instructions");
        meal.setVideoLink("http://youtube.com/test");
        meal.setTags(List.of("tag1", "tag2"));
        meal.setIngredientMeasurements(List.of(new IngredientMeasurement(new Ingredient(null, null ,"Ingredient1", null), null, null)));
        return List.of(meal);
    }
}
