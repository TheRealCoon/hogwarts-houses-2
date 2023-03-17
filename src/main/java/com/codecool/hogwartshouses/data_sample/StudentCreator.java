package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentCreator {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentCreator(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
        initialize();
    }

    public void initialize() {
        studentDAO.add(Student.builder().name("Hermione Granger").petType(PetType.CAT).houseType(HouseType.GRYFFINDOR).build());
        studentDAO.add(Student.builder().name("Harry Potter").petType(PetType.OWL).houseType(HouseType.GRYFFINDOR).build());
        studentDAO.add(Student.builder().name("Ron Weasley").petType(PetType.RAT).houseType(HouseType.GRYFFINDOR).build());
        studentDAO.add(Student.builder().name("Neville Longbottom").petType(PetType.NONE).houseType(HouseType.GRYFFINDOR).build());

        studentDAO.add(Student.builder().name("Draco Malfoy").petType(PetType.NONE).houseType(HouseType.SLYTHERIN).build());
        studentDAO.add(Student.builder().name("Vincent Crabbe").petType(PetType.NONE).houseType(HouseType.SLYTHERIN).build());
        studentDAO.add(Student.builder().name("Gregory Goyle").petType(PetType.RAT).houseType(HouseType.SLYTHERIN).build());
        studentDAO.add(Student.builder().name("Tracey Davis").petType(PetType.OWL).houseType(HouseType.SLYTHERIN).build());

        studentDAO.add(Student.builder().name("Hannah Abbott").petType(PetType.NONE).houseType(HouseType.HUFFLEPUFF).build());
        studentDAO.add(Student.builder().name("Susan Bones").petType(PetType.CAT).houseType(HouseType.HUFFLEPUFF).build());
        studentDAO.add(Student.builder().name("Zacharias Smith").petType(PetType.OWL).houseType(HouseType.HUFFLEPUFF).build());
        studentDAO.add(Student.builder().name("James Tuckett").petType(PetType.RAT).houseType(HouseType.HUFFLEPUFF).build());

        studentDAO.add(Student.builder().name("Roger Davies").petType(PetType.NONE).houseType(HouseType.RAVENCLAW).build());
        studentDAO.add(Student.builder().name("Luna Lovegood").petType(PetType.OWL).houseType(HouseType.RAVENCLAW).build());
        studentDAO.add(Student.builder().name("Felicity Eastchurch").petType(PetType.OWL).houseType(HouseType.RAVENCLAW).build());
        studentDAO.add(Student.builder().name("Ethan Bexley").petType(PetType.RAT).houseType(HouseType.RAVENCLAW).build());
    }
}
