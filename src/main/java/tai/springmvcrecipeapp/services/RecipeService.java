package tai.springmvcrecipeapp.services;

import tai.springmvcrecipeapp.domain.Recipe;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();
}