package com.codecool.hogwartshouses.DAO.mapper;

import com.codecool.hogwartshouses.model.enums.Ingredient;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@Component
public class IngredientMapper implements RowMapper<Ingredient> {
    @Override
    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Arrays.stream(Ingredient.values()).filter(i -> equals(rs, i))
                .findFirst()
                .orElse(null);
    }

    private static boolean equals(ResultSet rs, Ingredient i) {
        try {
            return rs.getString("ingredient").equals(i.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
