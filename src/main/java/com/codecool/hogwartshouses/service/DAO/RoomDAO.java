package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.PetType;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoomDAO {
    Set<Room> getAll();

    void add(Room room);

    Room findById(int id);

    void delete(int id); //todo could be a boolean to know if there was something deleted or no

    void renovate(int id);

    Set<Room> getAllAvailable();
    Set<Room> getByPetType(PetType... petTypes);

}