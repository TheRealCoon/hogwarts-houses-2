package com.codecool.hogwartshouses.DAO.implementation.database;

import com.codecool.hogwartshouses.DAO.StudentDAO;
import com.codecool.hogwartshouses.model.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class StudentDaoJdbcImpl implements StudentDAO {
    private final JdbcTemplate template;
    //TODO add mapper

    public StudentDaoJdbcImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void add(Student student) {

    }

    @Override
    public Student findByName(String name) {
        return null;
    }

    @Override
    public void update(long id, Student student) {

    }

    @Override
    public void delete(long id) {

    }
}
