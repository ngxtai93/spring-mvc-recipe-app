package tai.springmvcrecipeapp.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import tai.springmvcrecipeapp.commands.CategoryCommand;
import tai.springmvcrecipeapp.commands.IngredientCommand;
import tai.springmvcrecipeapp.commands.RecipeCommand;
import tai.springmvcrecipeapp.domain.Category;
import tai.springmvcrecipeapp.domain.Recipe;

import java.util.Set;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryCommandToCategory;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final NotesCommandToNotes notesCommandToNotes;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryCommandToCategory,
                                 IngredientCommandToIngredient ingredientCommandToIngredient,
                                 NotesCommandToNotes notesCommandToNotes) {
        this.categoryCommandToCategory = categoryCommandToCategory;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.notesCommandToNotes = notesCommandToNotes;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if(recipeCommand == null) return null;

        final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setServings(recipeCommand.getServings());
        recipe.setSource(recipeCommand.getSource());
        recipe.setUrl(recipeCommand.getUrl());

        recipe.setNotes(notesCommandToNotes.convert(recipeCommand.getNotes()));

        Set<CategoryCommand> categories = recipeCommand.getCategories();
        if(categories != null && categories.size() > 0) {
            categories.forEach(category -> recipe.getCategories()
                                .add(categoryCommandToCategory.convert(category)
                )
            );
        }
        Set<IngredientCommand> ingredients = recipeCommand.getIngredients();
        if(ingredients != null && ingredients.size() > 0) {
            ingredients.forEach(ingredient -> recipe.getIngredients()
                                .add(ingredientCommandToIngredient.convert(ingredient))
            );
        }
        return recipe;
    }
}
