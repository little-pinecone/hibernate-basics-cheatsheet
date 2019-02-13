package in.keepgrowing.hibernatebasicscheatsheet.meal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import in.keepgrowing.hibernatebasicscheatsheet.category.Category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Provide a meal name")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private GlutenPresence glutenPresence;

    @ManyToMany
    @JsonIgnore
    private Set<Allergen> allergens;

    @ManyToOne
    private Category category;

    public Meal() { }

    public static Meal of(String name) {
        Meal meal = new Meal();
        meal.name = name;
        return meal;
    }

    public static Meal withGlutenPresence(String name, GlutenPresence glutenPresence) {
        Meal meal = of(name);
        meal.glutenPresence = glutenPresence;
        return meal;
    }

    public String getName() {
        return name;
    }

    public GlutenPresence getGlutenPresence() {
        return glutenPresence;
    }

    public Set<Allergen> getAllergens() {
        return allergens;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return name.equals(meal.name) &&
                glutenPresence == meal.glutenPresence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, glutenPresence);
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", glutenPresence=" + glutenPresence +
                ", category=" + category +
                '}';
    }
}
