package mealgenerator.transformer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import mealgenerator.model.external.MealDbMeal;
import mealgenerator.model.internal.Meal;
import mealgenerator.model.internal.MealCategory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MealTransformerTest {

    @Autowired
    private Transformer<MealDbMeal, Meal> MealTransformer;

    @Test
    public void testTransform() {
        // Arrange
        MealDbMeal mealDbMeal = createMealDbMeal();

        // Act
        Meal meal = MealTransformer.transform(mealDbMeal);

        // Assert
        assertNotNull(meal);
        assertEquals(1L, meal.getSourceId());
        assertEquals("Test Meal", meal.getName());
        assertEquals(MealCategory.BEEF, meal.getCategory());
        assertEquals("American", meal.getArea());
        assertEquals("Test Instructions", meal.getInstructions());
        assertEquals("http://youtube.com/test", meal.getVideoLink());
        assertEquals(List.of("tag1", "tag2"), meal.getTags());
        assertEquals(1, meal.getIngredientMeasurements().size());
        assertEquals("Ingredient1", meal.getIngredientMeasurements().getFirst().getIngredient().getName());
    }

    @Test
    public void testTransformWithNullValues() {
        // Arrange
        MealDbMeal mealDbMeal = createMealDbMeal();
        mealDbMeal.setStrTags(null);
        mealDbMeal.setStrIngredient1(null);
        mealDbMeal.setStrMeasure1(null);

        // Act
        Meal meal = MealTransformer.transform(mealDbMeal);

        // Assert
        assertNotNull(meal);
        assertNull(meal.getTags());
        assertTrue(meal.getIngredientMeasurements().isEmpty());
    }

    private static MealDbMeal createMealDbMeal() {
        MealDbMeal mealDbMeal = new MealDbMeal();
        mealDbMeal.setIdMeal(1L);
        mealDbMeal.setStrMeal("Test Meal");
        mealDbMeal.setStrCategory("Beef");
        mealDbMeal.setStrArea("American");
        mealDbMeal.setStrInstructions("Test Instructions");
        mealDbMeal.setStrYoutube("http://youtube.com/test");
        mealDbMeal.setStrTags("tag1,tag2");
        mealDbMeal.setStrIngredient1("Ingredient1");
        mealDbMeal.setStrMeasure1("1 cup");

        return mealDbMeal;
    }

}
