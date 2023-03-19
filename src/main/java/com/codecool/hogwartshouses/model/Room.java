package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.enums.HouseType;
import com.codecool.hogwartshouses.model.enums.RoomCondition;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class Room {
    private final static int ROOM_CAPACITY = 3;
    @JsonIgnore
    private long id;
    private final Set<Student> students = new HashSet<>();
    private final HouseType houseType;
    private RoomCondition roomCondition;
    private boolean isFull;
    private long buildingId;

    public void addStudent(Student student) {
        if (!isFull && student.getHouseType().equals(houseType)) students.add(student);
        checkIfFull();
    }

    private void checkIfFull() {
        this.isFull = students.size() >= ROOM_CAPACITY;
    }
}
