package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentCreator {
    StudentDAO studentDAO;

    @Autowired
    public StudentCreator(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
        initialize();
    }

    public void initialize() {
        studentDAO.add(Student.builder().name("Hermione Granger").petType(PetType.CAT).houseType(HouseType.GRYFFINDOR).build());
        studentDAO.add(Student.builder().name("Draco Malfoy").petType(PetType.NONE).houseType(HouseType.SLYTHERIN).build());
    }
}
