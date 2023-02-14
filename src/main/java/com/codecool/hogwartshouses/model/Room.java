package com.codecool.hogwartshouses.model;

import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private int id;
    private Set<Student> students;
}
