package in.keepgrowing.hibernatebasicscheatsheet.meal;

import in.keepgrowing.hibernatebasicscheatsheet.meal.model.Meal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/meals")
public class MealController {

    private MealService service;

    public MealController(MealService service) {
        this.service = service;
    }

    @GetMapping
    public List<Meal> findAll() {
        return this.service.findAll();
    }
}
