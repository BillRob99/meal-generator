package mealgenerator.repository;

import mealgenerator.model.internal.Meal;
import mealgenerator.model.internal.MealCategory;

import java.util.List;

public interface CustomMealRepository {
    List<Meal> findByNameAndCategoryAndAreaAndTags(String name, MealCategory category, String area, String[] tags);
}
