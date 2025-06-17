package mealgenerator.service;

import mealgenerator.model.internal.ConversionDetails;
import mealgenerator.model.internal.IngredientMeasurement;

import java.math.BigDecimal;

public interface ConversionService {

    void setIngredientMeasurementUnits(IngredientMeasurement ingredientMeasurement, String unit, BigDecimal quantity);

    ConversionDetails getConversionByName(String name);
}
