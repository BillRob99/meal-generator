package mealgenerator.model.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Builder
@Document(collection = "meals")
@AllArgsConstructor
@NoArgsConstructor
public class Meal {

    @MongoId
    private String id;

    private Long sourceId;

    private String name;

    private String area;

    private MealCategory category;

    private String instructions;

    private List<String> tags;

    private String description;

    private String imageLink;

    private String videoLink;

    private List<IngredientMeasurement> ingredientMeasurements;
}
