package com.codecool.hogwartshouses.DAO.implementation.memory;

import com.codecool.hogwartshouses.DAO.StudentDAO;
import com.codecool.hogwartshouses.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StudentDaoMemoryImpl implements StudentDAO {
    private static long idCounter;
    private Set<Student> students;

    public StudentDaoMemoryImpl(Set<Student> students) {
        this.students = students;
    }

    @Override
    public List<Student> getAll() {
        return students.stream()
                .sorted(Comparator.comparing(Student::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void add(Student student) {
        student.setId(++idCounter);
        students.add(student);
    }

    @Override
    public Student findByName(String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Optional<Student> getById(long id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    @Override
    public void update(long id, Student student) {
        students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .ifPresent(s -> {
                    s.setName(student.getName());
                    s.setHouseType(student.getHouseType());
                    s.setPetType(student.getPetType());
                });
    }

    @Override
    public void delete(long id) {
        students.removeIf(s -> s.getId() == id);
    }
}
