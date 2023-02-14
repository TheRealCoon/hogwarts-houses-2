package com.codecool.hogwartshouses.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Set;


@Data
@Builder
public class Room {

    private final int id;
   @Singular private final Set<Student> students;
}
