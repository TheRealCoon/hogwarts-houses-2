package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.DAO.PotionDAO;
import com.codecool.hogwartshouses.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotionService {
private final PotionDAO potionDAO;

    public PotionService(PotionDAO potionDAO) {
        this.potionDAO = potionDAO;
    }

    public List<Recipe> getAllRecipes(){
        return potionDAO.getAllRecipes();
    }

}
