package com.codecool.hogwartshouses.DAO.mapper;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Student.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .houseType(HouseType.valueOf(rs.getString("house_type")))
                .petType(PetType.valueOf(rs.getString("pet_type")))
                .build();
    }
}
