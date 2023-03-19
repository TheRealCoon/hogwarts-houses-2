package com.codecool.hogwartshouses.DAO.implementation.memory;

import com.codecool.hogwartshouses.DAO.RoomDAO;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.enums.PetType;
import com.codecool.hogwartshouses.model.enums.RoomCondition;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RoomDaoMemoryImpl implements RoomDAO {
    private static long idCounter;
    private final Set<Room> rooms;

    public RoomDaoMemoryImpl(Set<Room> rooms) {
        this.rooms = rooms;
    }


    @Override
    public List<Room> getAll() {
        return rooms.stream()
                .sorted(Comparator.comparing(Room::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void add(Room room) {
        room.setId(++idCounter);
        rooms.add(room);
    }

    @Override
    public Optional<Room> findById(long id) {
        return rooms.stream()
                .filter(room -> room.getId() == id)
                .findFirst();
    }

    @Override
    public void delete(long id) {
        rooms.removeIf(r -> r.getId() == id);
    }

    @Override
    public void renovate(long id) {
        findById(id).ifPresent(r -> r.setRoomCondition(RoomCondition.RENOVATED));
    }

    public List<Room> getAllAvailable() {
        return rooms.stream()
                .filter(r -> !r.isFull())
                .sorted(Comparator.comparing(Room::getId))
                .collect(Collectors.toList());
    }

    public List<Room> getWithoutPetType(PetType... petTypes) {
        return rooms.stream()
                .filter(r -> r.getStudents()
                        .stream()
                        .noneMatch(s -> {
                            for (PetType petType : petTypes) {
                                if (s.getPetType().equals(petType)) return true;
                            }
                            return false;
                        }))
                .sorted(Comparator.comparing(Room::getId))
                .collect(Collectors.toList());
    }
}
