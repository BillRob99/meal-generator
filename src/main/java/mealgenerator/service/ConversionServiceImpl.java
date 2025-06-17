package mealgenerator.service;

import mealgenerator.model.internal.ConversionDetails;
import mealgenerator.model.internal.IngredientMeasurement;
import mealgenerator.repository.ConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    ConversionRepository conversionRepository;

    @Override
    public void setIngredientMeasurementUnits(IngredientMeasurement ingredientMeasurement, String unit, BigDecimal quantity) {
        ConversionDetails conversionDetails = getConversionByName(unit);

        ingredientMeasurement.setUnitOfMeasure(conversionDetails.getUnitOfMeasure());
        ingredientMeasurement.setQuantity(quantity.multiply(conversionDetails.getQuantity()));
    }

    @Override
    public ConversionDetails getConversionByName(String name) {
        return conversionRepository.findByName(name);
    }
}
