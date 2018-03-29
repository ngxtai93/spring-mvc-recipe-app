package tai.springmvcrecipeapp.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import tai.springmvcrecipeapp.commands.RecipeCommand;
import tai.springmvcrecipeapp.domain.Category;
import tai.springmvcrecipeapp.domain.Ingredient;
import tai.springmvcrecipeapp.domain.Recipe;

import java.util.Set;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
    private final CategoryToCategoryCommand categoryToCategoryCommand;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final NotesToNotesCommand notesToNotesCommand;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryToCategoryCommand,
                                 IngredientToIngredientCommand ingredientToIngredientCommand,
                                 NotesToNotesCommand notesToNotesCommand) {
        this.categoryToCategoryCommand = categoryToCategoryCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.notesToNotesCommand = notesToNotesCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {
        if(recipe == null) return null;

        final RecipeCommand recipeCommand = new RecipeCommand();

        recipeCommand.setId(recipe.getId());
        recipeCommand.setPrepTime(recipe.getPrepTime());
        recipeCommand.setCookTime(recipe.getCookTime());
        recipeCommand.setDescription(recipe.getDescription());
        recipeCommand.setDifficulty(recipe.getDifficulty());
        recipeCommand.setDirections(recipe.getDirections());
        recipeCommand.setServings(recipe.getServings());
        recipeCommand.setSource(recipe.getSource());
        recipeCommand.setUrl(recipe.getUrl());

        recipeCommand.setNotes(notesToNotesCommand.convert(recipe.getNotes()));

        Set<Category> categories = recipe.getCategories();
        if(categories != null && categories.size() > 0) {
            categories.forEach(category -> recipeCommand.getCategories()
                                .add(categoryToCategoryCommand.convert(category))
            );
        }

        Set<Ingredient> ingredients = recipe.getIngredients();
        if(ingredients != null && ingredients.size() > 0) {
            ingredients.forEach(ingredient -> recipeCommand.getIngredients()
                                    .add(ingredientToIngredientCommand.convert(ingredient))
            );
        }

        return recipeCommand;
    }
}
