package in.keepgrowing.hibernatebasicscheatsheet.category;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    Optional<Category> findById(Long id) {
        return this.repository.findById(id);
    }
}
