package guru.springframework.recipe.project.recipeproject.services;

import guru.springframework.recipe.project.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
