package mealgenerator.model;

import org.junit.jupiter.api.Test;
import mealgenerator.model.internal.MealCategory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MealCategoryTests {

    @Test
    public void testMealCategoryFromString() {
        assertEquals(MealCategory.BEEF, MealCategory.fromString("Beef"));
        assertEquals(MealCategory.CHICKEN, MealCategory.fromString("Chicken"));
        assertEquals(MealCategory.PORK, MealCategory.fromString("Pork"));
        assertEquals(MealCategory.SEAFOOD, MealCategory.fromString("Seafood"));
        assertEquals(MealCategory.GOAT, MealCategory.fromString("Goat"));
        assertEquals(MealCategory.LAMB, MealCategory.fromString("Lamb"));
        assertEquals(MealCategory.BREAKFAST, MealCategory.fromString("Breakfast"));
        assertEquals(MealCategory.STARTER, MealCategory.fromString("Starter"));
        assertEquals(MealCategory.SIDE, MealCategory.fromString("Side"));
        assertEquals(MealCategory.DESSERT, MealCategory.fromString("Dessert"));
        assertEquals(MealCategory.VEGETARIAN, MealCategory.fromString("Vegetarian"));
        assertEquals(MealCategory.VEGAN, MealCategory.fromString("Vegan"));
        assertEquals(MealCategory.PASTA, MealCategory.fromString("Pasta"));
        assertEquals(MealCategory.MISC, MealCategory.fromString("Miscellaneous"));
    }

    @Test
    public void testMealCategoryFromStringInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> MealCategory.fromString("InvalidCategory"));
        assertEquals("No enum constant for name: InvalidCategory", exception.getMessage());
    }

}
