package com.codecool.hogwartshouses.DAO.mapper;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.RoomCondition;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoomMapper implements RowMapper<Room> {
    @Override
    public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Room.builder()
                .id(rs.getLong("id"))
                .buildingId(rs.getLong("building_id"))
                .houseType(HouseType.valueOf(rs.getString("house_type")))
                .roomCondition(RoomCondition.valueOf(rs.getString("room_condition")))
                .build();
    }
}
