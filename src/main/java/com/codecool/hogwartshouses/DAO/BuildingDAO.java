package com.codecool.hogwartshouses.DAO;

import com.codecool.hogwartshouses.model.Building;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuildingDAO {
    List<Building> getAll();

    void add(Building building);

    Optional<Building> getById(long id);

    void update(long id, Building building);

    void delete(long id);
}
