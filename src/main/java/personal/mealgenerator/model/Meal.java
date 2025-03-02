package personal.mealgenerator.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Document(collection = "meals")
public class Meal {

    @MongoId
    private String id;

    private Long sourceId;

    private String name;

    private MealCategory category;

    private List<String> tags;

    private String description;

    private String imageLink;

    private String videoLink;

    private List<Ingredient> ingredients;
}
