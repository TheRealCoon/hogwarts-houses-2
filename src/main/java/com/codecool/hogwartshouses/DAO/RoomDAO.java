package com.codecool.hogwartshouses.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.PetType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomDAO {
    List<Room> getAll();

    void add(Room room);

    Room findById(int id);

    void delete(int id);

    void renovate(int id);

    List<Room> getAllAvailable();
    List<Room> getWithoutPetType(PetType... petTypes);

}