package com.codecool.hogwartshouses.DAO.implementation.memory;

import com.codecool.hogwartshouses.DAO.RoomDAO;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.model.types.RoomCondition;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class RoomDaoMemoryImpl implements RoomDAO {
    private static long idCounter;
    private Set<Room> rooms;

    public RoomDaoMemoryImpl(Set<Room> rooms) {
        this.rooms = rooms;
    }


    @Override
    public Set<Room> getAll() {
        return rooms;
    }

    @Override
    public void add(Room room) {
        room.setId(++idCounter);
        rooms.add(room);
    }

    @Override
    public Room findById(int id) {
        return rooms.stream()
                .filter(room -> room.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delete(int id) {
        rooms.removeIf(r -> r.getId() == id);
    }

    @Override
    public void renovate(int id) {
        findById(id).setRoomCondition(RoomCondition.RENOVATED);
    }

    public Set<Room> getAllAvailable() {
        return rooms.stream()
                .filter(r -> !r.isFull())
                .collect(Collectors.toSet());
    }

    public Set<Room> getWithoutPetType(PetType... petTypes) {
        Set<Room> filteredRooms = new HashSet<>();
        filteredRooms.addAll(rooms.stream()
                .filter(r -> r.getStudents()
                        .stream()
                        .noneMatch(s -> {
                            for (PetType petType : petTypes) {
                                if (s.getPetType().equals(petType)) return true;
                            }
                            return false;
                        }))
                .collect(Collectors.toSet()));
        return filteredRooms;
    }
}
