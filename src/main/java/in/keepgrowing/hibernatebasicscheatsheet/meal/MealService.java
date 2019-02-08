package in.keepgrowing.hibernatebasicscheatsheet.meal;

import in.keepgrowing.hibernatebasicscheatsheet.meal.model.Meal;
import in.keepgrowing.hibernatebasicscheatsheet.meal.model.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    List<Meal> findAll() {
        return this.repository.findAll();
    }
}
