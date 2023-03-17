package com.codecool.hogwartshouses.DAO.implementation.database;

import com.codecool.hogwartshouses.DAO.StudentDAO;
import com.codecool.hogwartshouses.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJdbc implements StudentDAO {
    private final JdbcTemplate template;
    //TODO add mapper

    public StudentJdbc(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void add(Student student) {

    }

    @Override
    public Student findByName(String name) {
        return null;
    }
}
