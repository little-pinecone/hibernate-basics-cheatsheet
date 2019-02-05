package in.keepgrowing.hibernatebasicscheatsheet.meal.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "menu_id")
    private List<Category> categories;

    @Override
    public String toString() {
        return "Menu{" +
                "categories=" + categories +
                '}';
    }
}
