package com.codecool.hogwartshouses.DAO.implementation.database;

import com.codecool.hogwartshouses.DAO.PotionDAO;
import com.codecool.hogwartshouses.DAO.mapper.IngredientMapper;
import com.codecool.hogwartshouses.DAO.mapper.RecipeMapper;
import com.codecool.hogwartshouses.model.Recipe;
import com.codecool.hogwartshouses.model.enums.Ingredient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class PotionDaoJdbcImpl implements PotionDAO {
    private final JdbcTemplate template;
    private final RecipeMapper recipeMapper;
    private final IngredientMapper ingredientMapper;

    public PotionDaoJdbcImpl(JdbcTemplate template, RecipeMapper recipeMapper, IngredientMapper ingredientMapper) {
        this.template = template;
        this.recipeMapper = recipeMapper;
        this.ingredientMapper = ingredientMapper;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        final String sql = "SELECT id, name FROM recipe;";
        List<Recipe> recipes = template.query(sql, recipeMapper);
        recipes.forEach(r -> r.setIngredients(getIngredientsFromDB(r)));
        return recipes;
    }

    @Override
    public void addKnownRecipeToStudent(long studentId, long recipeId) {
        final String sql = "INSERT INTO known_recipes (student_id, recipe_id) VALUES (?, ?);";
        template.update(sql, studentId, recipeId);
    }

    @Override
    public void add(long studentId, String name, List<Ingredient> ingredients) {
        long recipeId = addRecipe(name);
        ingredients.forEach(i -> addIngredientToRecipe(recipeId, i.toString()));
        addKnownRecipeToStudent(studentId, recipeId);
    }

    private void addIngredientToRecipe(long recipeId, String i) {
        final String sql = "INSERT INTO ingredients (recipe_id, ingredient) VALUES (?, ?);";
        template.update(sql, recipeId, i);
    }


    private long addRecipe(String name) {
        final String sql1 = "INSERT INTO recipe (name) VALUES (?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, name);
                    return ps;
                },
                keyHolder);
        return keyHolder.getKey().longValue();
    }

    private List<Ingredient> getIngredientsFromDB(Recipe recipe) {
        final String sql = "SELECT ingredient FROM ingredients WHERE recipe_id = ?;";
        return template.query(sql, ingredientMapper, recipe.getId());
    }
}
