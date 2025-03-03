package mealgenerator.repository;

import mealgenerator.model.internal.Meal;
import mealgenerator.model.internal.MealCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomMealRepositoryImpl implements CustomMealRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Meal> findByNameAndCategoryAndAreaAndTags(String name, MealCategory category, String area, String[] tags) {
        List<Criteria> criteriaList = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            criteriaList.add(Criteria.where("name").is(name));
        }
        if (category != null) {
            criteriaList.add(Criteria.where("category").is(category));
        }
        if (area != null && !area.isEmpty()) {
            criteriaList.add(Criteria.where("area").is(area));
        }

        if (tags != null) {
            for (String tag : tags) {
                criteriaList.add(Criteria.where("tags").is(tag));
            }
        }

        Query query = new Query();
        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList));
        }

        return mongoTemplate.find(query, Meal.class);
    }
}
