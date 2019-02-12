package in.keepgrowing.hibernatebasicscheatsheet.category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("SELECT DISTINCT c" +
            " FROM Category c" +
            " LEFT JOIN FETCH c.meals m")
    List<Category> findAll();
}
