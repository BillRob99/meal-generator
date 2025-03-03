package mealgenerator.proxy;

import mealgenerator.exception.DataLoadException;
import mealgenerator.model.external.MealDbMeal;
import mealgenerator.model.external.MealDbMealResponse;
import mealgenerator.model.external.MealDbMealSummary;
import mealgenerator.model.external.MealDbMealSummaryResponse;
import mealgenerator.model.internal.MealCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealDbProxyImpl implements MealDbProxy {

    @Autowired
    private RestTemplate restTemplate;

    private static final String MEAL_DB_URL = "https://www.themealdb.com/api/json/v1/1/";
    private static final String FILTER = "filter.php?";
    private static final String LOOKUP = "lookup.php?i=";




    @Override
    public List<MealDbMeal> getMealsByCategory(MealCategory category) {
        // Initial response is in summary format, we then need to query each meal by id
        String url = MEAL_DB_URL + FILTER + "c=" + category.toString();

        MealDbMealSummaryResponse response = restTemplate.getForObject(url, MealDbMealSummaryResponse.class);

        if (response != null) {
            return getMealsFromSummaryResponse(response);
        }
        throw new DataLoadException("Failed to load meals from MealDB");
    }

    private List<MealDbMeal> getMealsFromSummaryResponse(MealDbMealSummaryResponse summaryResponse) {
        List<MealDbMeal> meals = new ArrayList<>();

        for (MealDbMealSummary summary : summaryResponse.getMeals()) {
            String url = MEAL_DB_URL + LOOKUP + summary.getIdMeal();
            MealDbMealResponse mealResponse = restTemplate.getForObject(url, MealDbMealResponse.class);

            if (mealResponse != null && mealResponse.getMeals() != null && !mealResponse.getMeals().isEmpty()) {
                meals.add(mealResponse.getMeals().getFirst());
            }
        }

        return meals;
    }
}
