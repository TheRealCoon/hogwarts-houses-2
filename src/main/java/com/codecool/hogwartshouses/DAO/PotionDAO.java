package com.codecool.hogwartshouses.DAO;

import com.codecool.hogwartshouses.model.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PotionDAO {
    List<Recipe> getAllRecipes();
}
