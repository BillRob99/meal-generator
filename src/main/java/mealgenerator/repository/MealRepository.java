package mealgenerator.repository;

import mealgenerator.model.internal.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends MongoRepository<Meal, String> {

    @Query(value = "{ 'category' : ?0 }", delete = true)
    void deleteAllByCategory(String category);
}
