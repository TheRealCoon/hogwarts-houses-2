package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoomService {
    private RoomDAO roomDAO;

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
}
