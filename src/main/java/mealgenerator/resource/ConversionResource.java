package mealgenerator.resource;

import mealgenerator.model.internal.ConversionDetails;
import mealgenerator.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Purely for testing, can be removed once we are up and running.
 */
@RestController
@RequestMapping("/conversions")
public class ConversionResource {

    @Autowired
    ConversionService conversionService;

    @GetMapping
    public ConversionDetails getConversions(@RequestParam String measurementName) {

        return conversionService.getConversionByName(measurementName);
    }

}
