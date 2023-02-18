package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.RoomCondition;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Room {

    private final static int ROOM_CAPACITY = 3;
    private static int count;
    @Builder.Default private final int id = ++count;
    @Singular private final Set<Student> students = new HashSet<>();
    private final HouseType houseType;
    private RoomCondition roomCondition;
    private boolean isFull = false;

    public void addStudent(Student student){
        students.add(student);
        checkIfFull();
    }

    private void checkIfFull(){
        if(students.size() == ROOM_CAPACITY)
            this.isFull = true;
    }
}
