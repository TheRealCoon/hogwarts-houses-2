package com.codecool.hogwartshouses.DAO.implementation.database;

import com.codecool.hogwartshouses.DAO.BuildingDAO;
import com.codecool.hogwartshouses.model.Building;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class BuildingJdbc implements BuildingDAO {
    private final JdbcTemplate template;
    //TODO add mapper

    public BuildingJdbc(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Building> getAll() {
        return null;
    }

    @Override
    public void add(Building building) {

    }

    @Override
    public Optional<Building> getById(long id) {
        return Optional.empty();
    }

    @Override
    public void update(long id, Building building) {

    }

    @Override
    public void delete(long id) {

    }
}
