package mealgenerator.model.internal;

public enum MealCategory {
    BEEF ("Beef"),
    CHICKEN ("Chicken"),
    PORK ("Pork"),
    SEAFOOD ("Seafood"),
    GOAT ("Goat"),
    LAMB ("Lamb"),
    BREAKFAST ("Breakfast"),
    STARTER ("Starter"),
    SIDE ("Side"),
    DESSERT ("Dessert"),
    VEGETARIAN ("Vegetarian"),
    VEGAN ("Vegan"),
    PASTA ("Pasta"),
    MISC ("Miscellaneous");

    private final String NAME;

    MealCategory(String NAME) {
        this.NAME = NAME;
    }

    public static MealCategory fromString(String name) {
        for (MealCategory category : MealCategory.values()) {
            if (category.NAME.equalsIgnoreCase(name)) {
                return category;
            }
        }
        throw new IllegalArgumentException("No enum constant for name: " + name);
    }
}
