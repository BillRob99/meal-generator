package mealgenerator.service;

import mealgenerator.model.internal.Meal;
import mealgenerator.model.internal.MealCategory;

import java.util.List;

public interface MealService {

    List<Meal> getMeals(String name, MealCategory category, String area, String[] tag);

    Meal getMeal(String id);

    Meal createMeal(Meal meal);

    List<Meal> loadMealsByCategory(MealCategory category);
}
