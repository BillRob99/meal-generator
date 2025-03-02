package personal.mealgenerator.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "ingredients")
public class Ingredient {

    @MongoId
    private String id;

    private Long sourceId;

    private String name;

    private String description;

    private String imageLink;
}