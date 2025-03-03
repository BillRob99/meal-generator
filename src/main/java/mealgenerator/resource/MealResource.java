package mealgenerator.resource;

import mealgenerator.model.internal.Meal;
import mealgenerator.model.internal.MealCategory;
import mealgenerator.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealResource {

    @Autowired
    private MealService mealService;

    @GetMapping
    public List<Meal> getMeals(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) MealCategory category,
            @RequestParam(required = false) String area,
            @RequestParam(required = false) String[] tags) {

        return mealService.getMeals(name, category, area, tags);
    }

    @PostMapping
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.createMeal(meal);
    }

    @PostMapping("/load")
    public List<Meal> loadMealsByCategory(@RequestParam MealCategory category) {
        return mealService.loadMealsByCategory(category);
    }
}
