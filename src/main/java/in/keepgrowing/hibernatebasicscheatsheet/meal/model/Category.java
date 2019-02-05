package in.keepgrowing.hibernatebasicscheatsheet.meal.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "category")
    private List<Meal> meals;

    @Override
    public String toString() {
        return "Category{" +
                "meals=" + meals +
                '}';
    }
}
