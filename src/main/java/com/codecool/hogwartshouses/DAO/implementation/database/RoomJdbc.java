package com.codecool.hogwartshouses.DAO.implementation.database;

import com.codecool.hogwartshouses.DAO.RoomDAO;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.PetType;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Set;

public class RoomJdbc implements RoomDAO {
    private final JdbcTemplate template;
    //TODO add mapper

    public RoomJdbc(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Set<Room> getAll() {
        return null;
    }

    @Override
    public void add(Room room) {

    }

    @Override
    public Room findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void renovate(int id) {

    }

    @Override
    public Set<Room> getAllAvailable() {
        return null;
    }

    @Override
    public Set<Room> getWithoutPetType(PetType... petTypes) {
        return null;
    }
}
