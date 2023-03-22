package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.enums.Ingredient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Recipe {
//    @Id
//    @GeneratedValue
    private long id;
//    @Column(unique = true)
//    @NotBlank
    private String name;

//    @ElementCollection
//    @Size(min = 5, max = 5)
    private List<Ingredient> ingredients;
}
