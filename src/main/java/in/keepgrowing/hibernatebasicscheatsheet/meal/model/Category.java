package in.keepgrowing.hibernatebasicscheatsheet.meal.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Provide a category name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Meal> meals;

    public Category() {
    }

    public static Category of(String name) {
        Category category = new Category();
        category.name = name;
        return category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "meals=" + meals +
                '}';
    }
}
