package com.codecool.hogwartshouses.DAO;

import com.codecool.hogwartshouses.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDAO {

    List<Student> getAll();
    void add(Student student);
    Student findByName(String name);

    void update(long id, Student student);

    void delete(long id);
}
