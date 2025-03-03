package mealgenerator.service;

import mealgenerator.model.internal.Meal;
import mealgenerator.model.internal.MealCategory;
import mealgenerator.repository.CustomMealRepository;
import mealgenerator.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private CustomMealRepository customMealRepository;

    @Override
    public List<Meal> getMeals(String name, MealCategory category, String area, String[] tags) {
        return customMealRepository.findByNameAndCategoryAndAreaAndTags(name, category, area, tags);
    }

    @Override
    public Meal getMeal(String id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Meal createMeal(Meal meal) {
        return mealRepository.save(meal);
    }
}
