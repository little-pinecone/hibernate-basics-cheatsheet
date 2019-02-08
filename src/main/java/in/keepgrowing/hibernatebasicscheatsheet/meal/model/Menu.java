package in.keepgrowing.hibernatebasicscheatsheet.meal.model;

import in.keepgrowing.hibernatebasicscheatsheet.category.Category;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate start;

    private LocalDate end;

    public Menu() {
    }

    public static Menu ofRange(LocalDate start, LocalDate end) {
        Menu menu = new Menu();
        menu.start = start;
        menu.end = end;
        return menu;
    }

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
