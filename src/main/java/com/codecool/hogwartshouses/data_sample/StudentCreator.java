package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentCreator {
    @Autowired
    StudentDAO studentMemory;

    public StudentCreator() {
        initialize();
    }

    public void initialize() {
        studentMemory.add(Student.builder().name("Hermione Granger").petType(PetType.CAT).houseType(HouseType.GRYFFINDOR).build());
        studentMemory.add(Student.builder().name("Draco Malfoy").petType(PetType.NONE).houseType(HouseType.SLYTHERIN).build());
    }
}
