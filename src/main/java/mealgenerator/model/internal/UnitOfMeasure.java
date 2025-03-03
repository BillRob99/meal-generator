package mealgenerator.model.internal;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UnitOfMeasure {
    GRAM ("Gram"),
    LITER ("Liter");

    private final String name;

    UnitOfMeasure (String name) {
        this.name = name;
    }

    @JsonValue
    public String toString() {
        return name;
    }
}
