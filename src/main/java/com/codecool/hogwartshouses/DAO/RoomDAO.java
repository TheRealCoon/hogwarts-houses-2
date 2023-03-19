package com.codecool.hogwartshouses.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.enums.PetType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomDAO {
    List<Room> getAll();

    void add(Room room);

    Optional<Room> findById(long id);

    void delete(long id);

    void renovate(long id);

    List<Room> getAllAvailable();
    List<Room> getWithoutPetType(PetType... petTypes);

}