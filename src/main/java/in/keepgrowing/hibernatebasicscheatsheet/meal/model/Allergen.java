package in.keepgrowing.hibernatebasicscheatsheet.meal.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Provide an allergen name")
    private String name;

    @ManyToMany(mappedBy = "allergens")
    private Set<Meal> meals;

    public Allergen() {
    }

    public static Allergen of(String name) {
        Allergen allergen = new Allergen();
        allergen.name = name;
        return allergen;
    }

    public static Allergen withMeals(String name, Set<Meal> meals) {
        Allergen allergen = of(name);
        allergen.meals = meals;
        return allergen;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergen that = (Allergen) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Allergen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", meals=" + meals +
                '}';
    }
}
