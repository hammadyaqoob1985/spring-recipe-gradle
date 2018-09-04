package guru.springframework.recipe.project.recipeproject.controllers;

import guru.springframework.recipe.project.recipeproject.commands.RecipeCommand;
import guru.springframework.recipe.project.recipeproject.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class RecipeController {

    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"/recipe/{id}/show"})
    public String getRecipe(Model model, @PathVariable String id) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "/recipe/show";
    }

    @GetMapping({"/recipe/new"})
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());

        return "recipe/recipeform";
    }

    @GetMapping({"/recipe/{id}/update"})
    public String getRecipeCommand(Model model, @PathVariable String id) {
        model.addAttribute("recipe", recipeService.findCommandById(new Long(id)));
        return "recipe/recipeform";
    }

    @GetMapping({"/recipe/{id}/delete"})
    public String deleteById(@PathVariable String id) {
        log.debug("deleting recipe with id" + id);
        recipeService.deleteById(new Long(id));
        return "redirect:/";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand recipeCommand) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipeCommand);

        return "redirect:/recipe/" + savedCommand.getId() + "/show/";
    }

}