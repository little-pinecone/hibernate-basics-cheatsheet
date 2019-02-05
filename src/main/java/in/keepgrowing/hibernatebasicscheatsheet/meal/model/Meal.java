package in.keepgrowing.hibernatebasicscheatsheet.meal.model;

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
    private Set<FoodAllergen> foodAllergens;

    @ManyToOne
    private Category category;

    public Meal() { }

    public Meal(String name, GlutenPresence glutenPresence) {
        this.name = name;
        this.glutenPresence = glutenPresence;
    }

    public Meal(String name, GlutenPresence glutenPresence, Set<FoodAllergen> foodAllergens) {
        this.name = name;
        this.glutenPresence = glutenPresence;
        this.foodAllergens = foodAllergens;
    }

    public String getName() {
        return name;
    }

    public GlutenPresence getGlutenPresence() {
        return glutenPresence;
    }

    public Set<FoodAllergen> getFoodAllergens() {
        return foodAllergens;
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
                ", foodAllergens=" + foodAllergens +
                ", category=" + category +
                '}';
    }
}
