package personal.mealgenerator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import personal.mealgenerator.model.Ingredient;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {
}
