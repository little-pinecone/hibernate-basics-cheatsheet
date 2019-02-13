package in.keepgrowing.hibernatebasicscheatsheet.meal.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Long> {

    @Query("SELECT m" +
            " FROM Meal m" +
            " LEFT JOIN FETCH m.category c")
    List<Meal> findAll();
}
