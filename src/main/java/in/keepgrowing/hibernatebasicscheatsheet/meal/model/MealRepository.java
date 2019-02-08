package in.keepgrowing.hibernatebasicscheatsheet.meal.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Long> {

    List<Meal> findAll();
}
