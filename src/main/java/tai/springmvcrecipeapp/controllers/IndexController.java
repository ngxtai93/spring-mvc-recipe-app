package tai.springmvcrecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tai.springmvcrecipeapp.domain.Category;
import tai.springmvcrecipeapp.domain.UnitOfMeasure;
import tai.springmvcrecipeapp.repositories.CategoryRepository;
import tai.springmvcrecipeapp.repositories.UnitOfMeasureRepository;
import tai.springmvcrecipeapp.services.RecipeService;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
