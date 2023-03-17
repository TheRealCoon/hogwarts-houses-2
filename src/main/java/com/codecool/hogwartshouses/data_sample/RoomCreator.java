package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.RoomCondition;
import com.codecool.hogwartshouses.DAO.RoomDAO;
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
        room2.addStudent(studentService.findByName("Vincent Crabbe"));

        Room room3 = Room.builder().houseType(HouseType.GRYFFINDOR).roomCondition(RoomCondition.UGLY).build();
        roomDAO.add(room3);
        room3.addStudent(studentService.findByName("Harry Potter"));
        room3.addStudent(studentService.findByName("Ron Weasley"));
        room3.addStudent(studentService.findByName("Neville Longbottom"));

        Room room4 = Room.builder().houseType(HouseType.HUFFLEPUFF).roomCondition(RoomCondition.RENOVATED).build();
        roomDAO.add(room4);
        room4.addStudent(studentService.findByName("Hannah Abbott"));
        room4.addStudent(studentService.findByName("Susan Bones"));

        Room room5 = Room.builder().houseType(HouseType.HUFFLEPUFF).roomCondition(RoomCondition.OLD).build();
        roomDAO.add(room5);
        room5.addStudent(studentService.findByName("Zacharias Smith"));
        room5.addStudent(studentService.findByName("James Tuckett"));

        Room room6 = Room.builder().houseType(HouseType.RAVENCLAW).roomCondition(RoomCondition.UGLY).build();
        roomDAO.add(room6);
        room6.addStudent(studentService.findByName("Roger Davies"));
        room6.addStudent(studentService.findByName("Felicity Eastchurch"));
        room6.addStudent(studentService.findByName("Ethan Bexley"));

        Room room7 = Room.builder().houseType(HouseType.RAVENCLAW).roomCondition(RoomCondition.UGLY).build();
        roomDAO.add(room7);
        room7.addStudent(studentService.findByName("Luna Lovegood"));

        Room room8 = Room.builder().houseType(HouseType.SLYTHERIN).roomCondition(RoomCondition.OLD).build();
        roomDAO.add(room8);
        room8.addStudent(studentService.findByName("Gregory Goyle"));
        room8.addStudent(studentService.findByName("Tracey Davis"));

        Room room9 = Room.builder().build();
        roomDAO.add(room9);

    }
}
