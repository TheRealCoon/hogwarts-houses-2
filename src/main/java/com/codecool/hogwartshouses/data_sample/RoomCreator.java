package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.RoomCondition;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCreator {
    RoomDAO roomDAO;

    @Autowired
    public RoomCreator(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
        initialize();
    }

    public void initialize() {
        roomDAO.add(Room.builder().houseType(HouseType.RAVENCLAW).roomCondition(RoomCondition.OLD) .build());
        roomDAO.add(Room.builder().houseType(HouseType.HUFFLEPUFF).roomCondition(RoomCondition.RENOVATED).build());
    }
}
