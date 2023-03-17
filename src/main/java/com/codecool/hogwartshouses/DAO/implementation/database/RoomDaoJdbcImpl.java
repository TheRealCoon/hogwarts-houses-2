package com.codecool.hogwartshouses.DAO.implementation.database;

import com.codecool.hogwartshouses.DAO.RoomDAO;
import com.codecool.hogwartshouses.DAO.mapper.RoomMapper;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.PetType;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class RoomDaoJdbcImpl implements RoomDAO {
    private final JdbcTemplate template;
    private final RoomMapper mapper;

    public RoomDaoJdbcImpl(JdbcTemplate template, RoomMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    //TODO need to join resident everywhere to list residents also

    @Override
    public List<Room> getAll() {
        final String sql = "SELECT id, building_id, house_type, room_condition FROM room;";
        return template.query(sql, mapper);
    }

    @Override
    public void add(Room room) {
        final String sql = "INSERT INTO room (building_id, house_type, room_condition) VALUES (?, ?, ?);";
        template.update(sql, room.getBuildingId(), room.getHouseType().toString(), room.getRoomCondition().toString());
    }

    @Override
    public Optional<Room> findById(long id) {
        final String sql = "SELECT id, building_id, house_type, room_condition FROM room WHERE id = ?;";
        return template.query(sql, mapper, id).stream().findFirst();
    }

    @Override
    public void delete(long id) {
        final String sql = "DELETE FROM room WHERE id = ?;";
        template.update(sql, id);
    }

    @Override
    public void renovate(long id) {
        final String sql = "UPDATE room SET room_condition = 'RENOVATED' WHERE id = ?;";
        template.update(sql, id);
    }

    @Override
    public List<Room> getAllAvailable() {
        return null;
    }

    @Override
    public List<Room> getWithoutPetType(PetType... petTypes) {
        return null;
    }
}
