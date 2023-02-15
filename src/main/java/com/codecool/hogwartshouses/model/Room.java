package com.codecool.hogwartshouses.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Room {

    private static int count;
    @Builder.Default private final int id = ++count;
    @Singular private final Set<Student> students = new HashSet<>();


    public void addStudent(Student student){
        students.add(student);
    }
}
