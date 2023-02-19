package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoomService {
    private final RoomDAO roomDAO;

    @Autowired
    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public Set<Room> getAll() {
        return roomDAO.getAll();
    }

    public void add(Room room) {
        roomDAO.add(room);
    }

    public Room findById(int id) {
        return roomDAO.findById(id);
    }

    public void delete(int id) {
        roomDAO.delete(id);
    }

    public void renovate(int id) {
        roomDAO.renovate(id);
    }

    public Set<Room> getAllAvailable(){
        return roomDAO.getAllAvailable();
    }

    public Set<Room> getByPetType(PetType... petTypes){
        return roomDAO.getByPetType(petTypes);
    }

}
