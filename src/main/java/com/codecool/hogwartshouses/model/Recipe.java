package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.enums.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    private long id;
    private String name;
    private List<Ingredient> ingredients;
}
