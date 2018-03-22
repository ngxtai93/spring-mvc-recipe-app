package tai.springmvcrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tai.springmvcrecipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
