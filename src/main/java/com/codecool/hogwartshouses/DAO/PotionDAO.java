package com.codecool.hogwartshouses.DAO;

import com.codecool.hogwartshouses.model.Recipe;
import com.codecool.hogwartshouses.model.enums.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PotionDAO {
    List<Recipe> getAllRecipes();

    void addKnownRecipeToStudent(long studentId, long recipeId);

    void add(long studentId, String name, List<Ingredient> ingredients);

    boolean isPotionUnique(List<String> ingredients);

    void delete(long studentId, long recipeId);
}
