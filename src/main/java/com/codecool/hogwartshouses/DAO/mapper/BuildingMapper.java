package com.codecool.hogwartshouses.DAO.mapper;

import com.codecool.hogwartshouses.model.Building;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuildingMapper implements RowMapper<Building> {
    @Override
    public Building mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Building.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .build();
    }
}
