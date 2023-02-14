package com.codecool.hogwartshouses.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private int id;
    private Set<Student> students;

    public void addStudent(Student student){
        students.add(student);
    }
}
