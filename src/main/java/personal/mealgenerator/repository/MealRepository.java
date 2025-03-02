package personal.mealgenerator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import personal.mealgenerator.model.Meal;

public interface MealRepository extends MongoRepository<Meal, String> {
}
