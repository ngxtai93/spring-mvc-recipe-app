package tai.springmvcrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tai.springmvcrecipeapp.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
