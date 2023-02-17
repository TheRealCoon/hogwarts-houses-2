package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO {
    void add(Student student);

    Student findByName(String name);
}
