package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.DAO.PotionDAO;
import com.codecool.hogwartshouses.DAO.StudentDAO;
import com.codecool.hogwartshouses.model.Recipe;
import com.codecool.hogwartshouses.model.enums.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PotionService {
    private final PotionDAO potionDAO;
    private final StudentDAO studentDAO;

    public PotionService(PotionDAO potionDAO, StudentDAO studentDAO) {
        this.potionDAO = potionDAO;
        this.studentDAO = studentDAO;
    }

    public List<Recipe> getAllRecipes() {
        return potionDAO.getAllRecipes();
    }

    public void add(long studentId, String name, List<String> stringIngredients) {
        List<Ingredient> ingredients = parseIngredientList(stringIngredients);
        getRecipeIfAlreadyExists(ingredients, studentDAO.getById(studentId).orElseThrow().getKnownRecipes())
                .ifPresentOrElse(
                        r -> potionDAO.addKnownRecipeToStudent(studentId, r.getId()),
                        () -> potionDAO.add(studentId, name, ingredients)
                );
    }

    private List<Ingredient> parseIngredientList(List<String> stringIngredients) {
        return stringIngredients.stream()
                .map(Ingredient::getByStringValue)
                .collect(Collectors.toList());
    }

    private Optional<Recipe> getRecipeIfAlreadyExists(List<Ingredient> ingredients, Set<Recipe> recipesOfStudent) {
        return recipesOfStudent.stream()
                .filter(r -> ingredients.equals(r.getIngredients()))
                .findFirst();
    }

    public boolean isPotionUnique(List<String> ingredients) {
        return potionDAO.isPotionUnique(ingredients);
    }

    public void delete(long studentId, long recipeId) {
        potionDAO.delete(studentId, recipeId);
    }
}
