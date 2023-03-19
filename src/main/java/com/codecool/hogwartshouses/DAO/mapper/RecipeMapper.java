package com.codecool.hogwartshouses.DAO.mapper;

import com.codecool.hogwartshouses.model.Recipe;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RecipeMapper implements RowMapper<Recipe> {
    @Override
    public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Recipe.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .build();
    }
}
