package guru.springframework.recipe.project.recipeproject.controllers;

import guru.springframework.recipe.project.recipeproject.domain.Recipe;
import guru.springframework.recipe.project.recipeproject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
@Slf4j
@Controller
public class IndexController {

   @Autowired
   RecipeService recipeService;

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {
        log.debug("getting index page");
        Set<Recipe> recipeSet = recipeService.getRecipes();
        model.addAttribute("recipes", recipeSet);
        return "index";
    }
}
