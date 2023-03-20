package com.codecool.hogwartshouses.DAO.implementation.database;

import com.codecool.hogwartshouses.DAO.StudentDAO;
import com.codecool.hogwartshouses.DAO.mapper.RecipeMapper;
import com.codecool.hogwartshouses.DAO.mapper.StudentMapper;
import com.codecool.hogwartshouses.model.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
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
        List<Student> students = template.query(sql, mapper);
        students.forEach(s -> s.setKnownRecipes(new HashSet<>(getKnownRecipes(s))));
        return students;
    }

    private void getKnownRecipes(Student student){
        final String sql =
                "SELECT r.id, r.name FROM recipe AS r " +
                "JOIN known_recipes AS kr ON r.id = kr.recipe_id " +
                "WHERE kr.student_id = ?;";
        template.query(sql, new RecipeMapper(), student.getId());
    }

    @Override
    public void add(Student student) {
        final String sql = "INSERT INTO student (name, pet_type, house_type) VALUES (?, ?, ?);";
        template.update(sql, student.getName(), student.getPetType().toString(), student.getHouseType().toString());
        //TODO if has recipes at creation those need to be added
    }

    @Override
    public Student findByName(String name) {
        final String sql = "SELECT id, name, pet_type, house_type FROM student WHERE name = ?;";
        Optional<Student> maybeStudent = template.query(sql, mapper, name).stream().findFirst();
        maybeStudent.ifPresent(s -> s.setKnownRecipes(new HashSet<>(getKnownRecipes(s))));
        return maybeStudent.get();
    }

    @Override
    public Optional<Student> getById(long id) {
        final String sql = "SELECT id, name, pet_type, house_type FROM student WHERE id = ?;";
        Optional<Student> maybeStudent = template.query(sql, mapper, id).stream().findFirst();
        maybeStudent.ifPresent(s -> s.setKnownRecipes(new HashSet<>(getKnownRecipes(s))));
        return maybeStudent;
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
