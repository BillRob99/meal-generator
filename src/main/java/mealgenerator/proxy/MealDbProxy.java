package mealgenerator.proxy;

import mealgenerator.model.external.MealDbMeal;
import mealgenerator.model.internal.MealCategory;

import java.util.List;

public interface MealDbProxy {

    List<MealDbMeal> getMealsByCategory(MealCategory category);
}
