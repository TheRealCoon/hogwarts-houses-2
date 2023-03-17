package com.codecool.hogwartshouses.DAO.implementation.database;

import com.codecool.hogwartshouses.DAO.StudentDAO;
import com.codecool.hogwartshouses.DAO.mapper.StudentMapper;
import com.codecool.hogwartshouses.model.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class StudentDaoJdbcImpl implements StudentDAO {
    private final JdbcTemplate template;
    private final StudentMapper mapper;

    public StudentDaoJdbcImpl(JdbcTemplate template, StudentMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Override
    public List<Student> getAll() {
        final String sql = "SELECT id, name, pet_type, house_type FROM student;";
        return template.query(sql, mapper);
    }

    @Override
    public void add(Student student) {
        final String sql = "INSERT INTO student (name, pet_type, house_type) VALUES (?, ?, ?);";
        template.update(sql, student.getName(), student.getPetType().toString(), student.getHouseType().toString());
    }

    @Override
    public Student findByName(String name) {
        final String sql = "SELECT id, name, pet_type, house_type FROM student WHERE name = ?;";
        return template.query(sql, mapper, name).stream().findFirst().orElse(null);
    }

    @Override
    public Optional<Student> findById(long id) {
        final String sql = "SELECT id, name, pet_type, house_type FROM student WHERE id = ?;";
        return template.query(sql, mapper, id).stream().findFirst();
    }


    @Override
    public void update(long id, Student student) {
        final String sql = "UPDATE student SET name = ?, pet_type = ?, house_type = ? WHERE id = ?;";
        template.update(sql, student.getName(), student.getPetType().toString(), student.getHouseType().toString());
    }

    @Override
    public void delete(long id) {
        final String sql = "DELETE FROM student WHERE id = ?;";
        template.update(sql, id);
    }
}
