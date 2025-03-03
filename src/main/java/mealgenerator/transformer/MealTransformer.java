package mealgenerator.transformer;

import org.springframework.stereotype.Component;
import mealgenerator.model.external.MealDbMeal;
import mealgenerator.model.internal.Ingredient;
import mealgenerator.model.internal.IngredientMeasurement;
import mealgenerator.model.internal.Meal;
import mealgenerator.model.internal.MealCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MealTransformer implements Transformer<MealDbMeal, Meal> {

    @Override
    public Meal transform(MealDbMeal source) {
        Meal meal = new Meal();
        meal.setSourceId(source.getIdMeal());
        meal.setName(source.getStrMeal());
        meal.setCategory(MealCategory.fromString(source.getStrCategory()));
        meal.setArea(source.getStrArea());
        meal.setInstructions(source.getStrInstructions());
        meal.setVideoLink(source.getStrYoutube());

        if (source.getStrTags() != null && !source.getStrTags().isEmpty()) {
            meal.setTags(new ArrayList<>(Arrays.asList(source.getStrTags().split(","))));
        }

        List<IngredientMeasurement> ingredientMeasurements = new ArrayList<>();
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient1(), source.getStrMeasure1());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient2(), source.getStrMeasure2());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient3(), source.getStrMeasure3());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient4(), source.getStrMeasure4());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient5(), source.getStrMeasure5());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient6(), source.getStrMeasure6());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient7(), source.getStrMeasure7());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient8(), source.getStrMeasure8());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient9(), source.getStrMeasure9());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient10(), source.getStrMeasure10());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient11(), source.getStrMeasure11());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient12(), source.getStrMeasure12());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient13(), source.getStrMeasure13());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient14(), source.getStrMeasure14());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient15(), source.getStrMeasure15());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient16(), source.getStrMeasure16());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient17(), source.getStrMeasure17());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient18(), source.getStrMeasure18());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient19(), source.getStrMeasure19());
        addIngredientMeasurementToList(ingredientMeasurements, source.getStrIngredient20(), source.getStrMeasure20());
        meal.setIngredientMeasurements(ingredientMeasurements);

        return meal;
    }


    private static void addIngredientMeasurementToList(List<IngredientMeasurement> ingredientMeasurements, String ingredientName, String amount) {

        if (ingredientName == null || ingredientName.isEmpty() || amount == null || amount.isEmpty()) {
            return;
        }

        IngredientMeasurement ingredientMeasurement = new IngredientMeasurement();
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientName);
        ingredientMeasurement.setIngredient(ingredient);
        // TODO: Implement conversion to unit of measure + amount

        ingredientMeasurements.add(ingredientMeasurement);
    }
}
