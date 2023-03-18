package com.codecool.hogwartshouses.DAO.implementation.database;

import com.codecool.hogwartshouses.DAO.BuildingDAO;
import com.codecool.hogwartshouses.DAO.mapper.BuildingMapper;
import com.codecool.hogwartshouses.model.Building;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class BuildingDaoJdbcImpl implements BuildingDAO {
    private final JdbcTemplate template;
    private final BuildingMapper mapper;

    public BuildingDaoJdbcImpl(JdbcTemplate template, BuildingMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Override
    public List<Building> getAll() {
        final String sql = "SELECT id, name FROM building;";
        return template.query(sql, mapper);
    }

    @Override
    public void add(Building building) {
        final String sql = "INSERT INTO building (name) VALUES (?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(
                            sql,
                            Statement.RETURN_GENERATED_KEYS
                    );
                    ps.setString(1, building.getName());
                    return ps;
                },
                keyHolder
        );
        building.setId(keyHolder.getKey().longValue());
    }

    @Override
    public Optional<Building> getById(long id) {
        final String sql = "SELECT id, name FROM building WHERE id = ?;";
        return template.query(sql, mapper, id).stream().findFirst();
    }

    @Override
    public void update(long id, Building building) {
        final String sql = "UPDATE building SET name = ? WHERE id = ?;";
        template.update(sql, building.getName(), id);
    }

    @Override
    public void delete(long id) {
        final String sql = "DELETE FROM building WHERE id = ?;";
        template.update(sql, id);
    }
}
