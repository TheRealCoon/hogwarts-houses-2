package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.RoomCondition;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Room {
    private final static int ROOM_CAPACITY = 3;
    @JsonIgnore
    private  long id;
    private final Set<Student> students = new HashSet<>();
    private final HouseType houseType;
    private RoomCondition roomCondition;
    private boolean isFull;

    public void addStudent(Student student) {
        if (!isFull && student.getHouseType().equals(houseType)) students.add(student);
        checkIfFull();
    }

    private void checkIfFull() {
        if (students.size() == ROOM_CAPACITY)
            this.isFull = true;
    }
}
