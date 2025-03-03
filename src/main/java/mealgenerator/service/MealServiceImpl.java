package mealgenerator.service;

import mealgenerator.model.external.MealDbMeal;
import mealgenerator.model.internal.Meal;
import mealgenerator.model.internal.MealCategory;
import mealgenerator.proxy.MealDbProxy;
import mealgenerator.repository.CustomMealRepository;
import mealgenerator.repository.MealRepository;
import mealgenerator.transformer.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private CustomMealRepository customMealRepository;

    @Autowired
    private MealDbProxy mealDbProxy;

    @Autowired
    private Transformer<MealDbMeal, Meal> mealDbTransformer;

    /**
     * Get meals by name, category, area and tags. If any of the parameters is null, it will be ignored.
     * @param name Name of the meal.
     * @param category Category of the meal.
     * @param area Area of the meal.
     * @param tags Tags of the meal.
     * @return List of meals that match the criteria.
     */
    @Override
    public List<Meal> getMeals(String name, MealCategory category, String area, String[] tags) {
        return customMealRepository.findByNameAndCategoryAndAreaAndTags(name, category, area, tags);
    }

    /**
     * Get meal by id.
     * @param id ID of the meal.
     * @return Meal with the given ID.
     */
    @Override
    public Meal getMeal(String id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Create a meal.
     * @param meal Meal to create.
     * @return Created meal.
     */
    @Override
    public Meal createMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    /**
     * Load meals by category from the MealDB API. First deletes all meals of the given category and then loads new ones.
     * @param category Category of the meals to load.
     * @return List of meals loaded from the MealDB API.
     */
    @Override
    @Transactional
    public List<Meal> loadMealsByCategory(MealCategory category) {
        mealRepository.deleteAllByCategory(category.toString());

        List<Meal> meals = getMealsFromMealDbByCategory(category);
        meals = mealRepository.saveAll(meals);
        return meals;
    }


    private List<Meal> getMealsFromMealDbByCategory(MealCategory category) {
        List<MealDbMeal> mealDbMeals = mealDbProxy.getMealsByCategory(category);
        return mealDbMeals.stream().map(meal -> mealDbTransformer.transform(meal)).toList();
    }
}


