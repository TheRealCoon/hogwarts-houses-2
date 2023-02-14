package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//TODO abstract Creator class
@Component
public class RoomCreator {
    @Autowired
    RoomDAO roomMemory;

    public RoomCreator() {
        initialize();
    }

    public void initialize() {
        roomMemory.add(Room.builder().id(1).build());
        roomMemory.add(Room.builder().id(2).build());
    }
}
