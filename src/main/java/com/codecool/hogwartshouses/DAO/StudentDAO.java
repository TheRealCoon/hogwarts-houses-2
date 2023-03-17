package com.codecool.hogwartshouses.DAO;

import com.codecool.hogwartshouses.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO {
    void add(Student student);
    Student findByName(String name);

    void update(long id, Student student);

    void delete(long id);
}
