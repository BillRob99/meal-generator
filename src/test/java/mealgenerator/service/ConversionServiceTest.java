package mealgenerator.service;

import mealgenerator.model.internal.ConversionDetails;
import mealgenerator.model.internal.IngredientMeasurement;
import mealgenerator.model.internal.UnitOfMeasure;
import mealgenerator.repository.ConversionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ConversionServiceTest {

    @MockitoBean
    private ConversionRepository conversionRepository;

    @Autowired
    ConversionService conversionService;

    @Test
    void testGetConversionByName() {
        // Arrange
        ConversionDetails expectedDetails = createConversionDetails();
        when(conversionRepository.findByName(expectedDetails.getName())).thenReturn(expectedDetails);

        // Act
        ConversionDetails result = conversionService.getConversionByName(expectedDetails.getName());

        // Assert
        Assertions.assertEquals(expectedDetails, result);
    }

    @Test
    void testSetIngredientMeasurementUnits() {
        // Arrange
        ConversionDetails conversionDetails = createConversionDetails();
        when(conversionRepository.findByName(conversionDetails.getName())).thenReturn(conversionDetails);

        IngredientMeasurement ingredientMeasurement = new IngredientMeasurement();
        String unit = conversionDetails.getName();
        BigDecimal quantity = BigDecimal.valueOf(5);

        BigDecimal expectedQuantity = conversionDetails.getQuantity().multiply(quantity);

        // Act
        conversionService.setIngredientMeasurementUnits(ingredientMeasurement, unit, quantity);

        // Assert
        Assertions.assertEquals(conversionDetails.getUnitOfMeasure(), ingredientMeasurement.getUnitOfMeasure());
        Assertions.assertEquals(0, expectedQuantity.compareTo(ingredientMeasurement.getQuantity()));
    }

    private ConversionDetails createConversionDetails() {
        ConversionDetails conversionDetails = new ConversionDetails();
        conversionDetails.setName("Test Conversion");
        conversionDetails.setUnitOfMeasure(UnitOfMeasure.GRAM);
        conversionDetails.setQuantity(BigDecimal.TEN);
        return conversionDetails;
    }
}
