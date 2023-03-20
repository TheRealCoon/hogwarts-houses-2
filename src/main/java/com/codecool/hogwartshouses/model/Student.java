package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.enums.HouseType;
import com.codecool.hogwartshouses.model.enums.PetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
 private long id;
 private String name;
 private HouseType houseType;
 private PetType petType;
 private Set<Recipe> knownRecipes = new HashSet<>();
}
