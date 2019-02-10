package in.keepgrowing.hibernatebasicscheatsheet.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> findAll() {
        return service.findAll();
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<Category> findById(@PathVariable Long categoryId) {
        Optional<Category> category = service.findById(categoryId);
        return category.map(c -> ResponseEntity.ok().body(c))
                .orElse(ResponseEntity.notFound().build());
    }
}
