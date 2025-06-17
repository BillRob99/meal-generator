package mealgenerator.repository;

import mealgenerator.model.internal.ConversionDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends MongoRepository<ConversionDetails, String> {

    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    ConversionDetails findByName(String name);
}
