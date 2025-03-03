package mealgenerator.model.external;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MealDbMealResponse {
    private List<MealDbMeal> meals;
}
