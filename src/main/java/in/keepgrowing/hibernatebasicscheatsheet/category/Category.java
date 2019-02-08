package in.keepgrowing.hibernatebasicscheatsheet.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.keepgrowing.hibernatebasicscheatsheet.meal.model.Meal;

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
    @JsonIgnore
    private List<Meal> meals;

    public Category() {
    }

    public static Category of(String name) {
        Category category = new Category();
        category.name = name;
        return category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
