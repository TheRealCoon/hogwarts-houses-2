package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.RoomCondition;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Room {

    private static int count;
    @Builder.Default private final int id = ++count;
    @Singular private final Set<Student> students = new HashSet<>();
    private final HouseType houseType;
    private RoomCondition roomCondition;

    public void addStudent(Student student){
        students.add(student);
    }
}
