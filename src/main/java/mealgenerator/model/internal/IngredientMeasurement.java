package mealgenerator.model.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
@Builder
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
public class IngredientMeasurement {

    private Ingredient ingredient;

    private BigDecimal measurement;

    private UnitOfMeasure unitOfMeasure;
}
