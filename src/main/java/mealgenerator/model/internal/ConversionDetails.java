package mealgenerator.model.internal;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Data
@Document(collection = "conversions")
public class ConversionDetails {

    @MongoId
    private String id;

    private String name;

    private UnitOfMeasure unitOfMeasure;

    private BigDecimal quantity;
}
