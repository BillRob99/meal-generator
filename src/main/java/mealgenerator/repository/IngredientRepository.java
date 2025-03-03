package mealgenerator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import mealgenerator.model.internal.Ingredient;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String> {
}
