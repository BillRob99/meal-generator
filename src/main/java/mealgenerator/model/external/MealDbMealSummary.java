package mealgenerator.model.external;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MealDbMealSummary {
    private String strMeal;
    private String idMeal;
}
