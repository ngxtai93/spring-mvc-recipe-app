package tai.springmvcrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tai.springmvcrecipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
