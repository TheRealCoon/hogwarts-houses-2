package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.enums.HouseType;
import com.codecool.hogwartshouses.model.enums.RoomCondition;
import com.codecool.hogwartshouses.DAO.RoomDAO;
import com.codecool.hogwartshouses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("studentCreator")
public class RoomCreator {
    private final RoomDAO roomDAO;
    private final StudentService studentService;

    @Autowired
    public RoomCreator(RoomDAO roomDAO, StudentService studentService) {
        this.roomDAO = roomDAO;
        this.studentService = studentService;
        initialize();
    }

    public void initialize() {
        Room room1  = Room.builder().buildingId(1).houseType(HouseType.GRYFFINDOR).roomCondition(RoomCondition.OLD).build();
        room1.addStudent(studentService.findByName("Hermione Granger"));
        roomDAO.add(room1);

        Room room2 = Room.builder().buildingId(2).houseType(HouseType.SLYTHERIN).roomCondition(RoomCondition.MESSY).build();
        room2.addStudent(studentService.findByName("Draco Malfoy"));
        room2.addStudent(studentService.findByName("Vincent Crabbe"));
        roomDAO.add(room2);

        Room room3 = Room.builder().buildingId(1).houseType(HouseType.GRYFFINDOR).roomCondition(RoomCondition.UGLY).build();
        room3.addStudent(studentService.findByName("Harry Potter"));
        room3.addStudent(studentService.findByName("Ron Weasley"));
        room3.addStudent(studentService.findByName("Neville Longbottom"));
        roomDAO.add(room3);

        Room room4 = Room.builder().buildingId(3).houseType(HouseType.HUFFLEPUFF).roomCondition(RoomCondition.RENOVATED).build();
        room4.addStudent(studentService.findByName("Hannah Abbott"));
        room4.addStudent(studentService.findByName("Susan Bones"));
        roomDAO.add(room4);

        Room room5 = Room.builder().buildingId(1).houseType(HouseType.HUFFLEPUFF).roomCondition(RoomCondition.OLD).build();
        room5.addStudent(studentService.findByName("Zacharias Smith"));
        room5.addStudent(studentService.findByName("James Tuckett"));
        roomDAO.add(room5);

        Room room6 = Room.builder().buildingId(4).houseType(HouseType.RAVENCLAW).roomCondition(RoomCondition.UGLY).build();
        room6.addStudent(studentService.findByName("Roger Davies"));
        room6.addStudent(studentService.findByName("Felicity Eastchurch"));
        room6.addStudent(studentService.findByName("Ethan Bexley"));
        roomDAO.add(room6);

        Room room7 = Room.builder().buildingId(4).houseType(HouseType.RAVENCLAW).roomCondition(RoomCondition.UGLY).build();
        room7.addStudent(studentService.findByName("Luna Lovegood"));
        roomDAO.add(room7);

        Room room8 = Room.builder().buildingId(1).houseType(HouseType.SLYTHERIN).roomCondition(RoomCondition.OLD).build();
        room8.addStudent(studentService.findByName("Gregory Goyle"));
        room8.addStudent(studentService.findByName("Tracey Davis"));
        roomDAO.add(room8);

        Room room9 = Room.builder().buildingId(5).houseType(HouseType.RAVENCLAW).roomCondition(RoomCondition.RENOVATED).build();
        roomDAO.add(room9);

    }
}
