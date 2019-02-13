package in.keepgrowing.hibernatebasicscheatsheet.category;

import in.keepgrowing.hibernatebasicscheatsheet.meal.model.Meal;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findsAll() {
        List<Category> categories = repository.findAll();
        categories.forEach((c)-> entityManager.detach(c));
        Meal firstMeal = categories.get(0).getMeals().get(0);
        assertEquals("Oatmeal", firstMeal.getName());
    }

    @Test(expected = LazyInitializationException.class)
    public void findsById() {
        Optional<Category> category = repository.findById(1L);
        entityManager.detach(category.get());
        List<Meal> meals = category.get().getMeals();
        meals.forEach(m-> System.out.println(m.getName()));
    }

}