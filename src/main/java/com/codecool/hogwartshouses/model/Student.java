package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.enums.HouseType;
import com.codecool.hogwartshouses.model.enums.PetType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
 @JsonIgnore
 private long id;
 private String name;
 private HouseType houseType;
 private PetType petType;

}
