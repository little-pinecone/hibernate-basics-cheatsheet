package in.keepgrowing.hibernatebasicscheatsheet.meal.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
public class FoodAllergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Provide an allergen name")
    private String name;

    @ManyToMany(mappedBy = "foodAllergens")
    private Set<Meal> occurences;

    public FoodAllergen() {
    }

    public FoodAllergen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodAllergen that = (FoodAllergen) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "FoodAllergen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", occurences=" + occurences +
                '}';
    }
}
