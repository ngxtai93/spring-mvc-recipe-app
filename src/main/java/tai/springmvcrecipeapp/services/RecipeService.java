package tai.springmvcrecipeapp.services;

import tai.springmvcrecipeapp.commands.RecipeCommand;
import tai.springmvcrecipeapp.domain.Recipe;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
