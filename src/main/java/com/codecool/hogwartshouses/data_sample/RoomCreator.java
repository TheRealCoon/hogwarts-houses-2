package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.RoomCondition;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import com.codecool.hogwartshouses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCreator {
    private final RoomDAO roomDAO;
    private final StudentService studentService;

    @Autowired
    public RoomCreator(RoomDAO roomDAO, StudentCreator studentCreator, StudentService studentService) {
        this.roomDAO = roomDAO;
        this.studentService = studentService;
        initialize();
    }

    public void initialize() {
        Room room1  = Room.builder().houseType(HouseType.GRYFFINDOR).roomCondition(RoomCondition.OLD).build();
        roomDAO.add(room1);
        room1.addStudent(studentService.findByName("Hermione Granger"));
        Room room2 = Room.builder().houseType(HouseType.SLYTHERIN).roomCondition(RoomCondition.MESSY).build();
        roomDAO.add(room2);
        room2.addStudent(studentService.findByName("Draco Malfoy"));

    }
}
