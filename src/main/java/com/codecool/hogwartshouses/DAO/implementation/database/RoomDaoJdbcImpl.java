package com.codecool.hogwartshouses.DAO.implementation.database;

import com.codecool.hogwartshouses.DAO.RoomDAO;
import com.codecool.hogwartshouses.DAO.mapper.RoomMapper;
import com.codecool.hogwartshouses.DAO.mapper.StudentMapper;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.enums.PetType;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary
public class RoomDaoJdbcImpl implements RoomDAO {
    private final JdbcTemplate template;
    private final RoomMapper mapper;

    public RoomDaoJdbcImpl(JdbcTemplate template, RoomMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Override
    public List<Room> getAll() {
        final String sql = "SELECT id, building_id, house_type, room_condition FROM room;";
        List<Room> rooms = template.query(sql, mapper);
        getResidents(rooms);
        return rooms;
    }

    private void getResidents(List<Room> rooms) {
        final String sql = "SELECT s.id, s.name, s.house_type, s.pet_type FROM student AS s " +
                "JOIN resident AS r ON s.id = r.student_id " +
                "WHERE r.room_id = ?;";
        for (Room room : rooms) {
            template.query(sql, new StudentMapper(), room.getId()).forEach(room::addStudent);
        }
    }

    private void linkResidents(Room room) {
        final String sql = "INSERT INTO resident (student_id, room_id) VALUES (?, ?);";
        room.getStudents().forEach(s -> template.update(sql, s.getId(), room.getId()));
    }

    @Override
    public void add(Room room) {
        final String sql = "INSERT INTO room (building_id, house_type, room_condition) VALUES (?, ?, ?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(
                            sql,
                            Statement.RETURN_GENERATED_KEYS
                    );
                    ps.setLong(1, room.getBuildingId());
                    ps.setString(2, room.getHouseType().toString());
                    ps.setString(3, room.getRoomCondition().toString());
                    return ps;
                },
                keyHolder
        );
        room.setId(keyHolder.getKey().longValue());
        linkResidents(room);
    }

    @Override
    public Optional<Room> findById(long id) {
        final String sql = "SELECT id, building_id, house_type, room_condition FROM room WHERE id = ?;";
        List<Room> rooms = template.query(sql, mapper, id);
        getResidents(rooms);
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
        return getAll().stream()
                .filter(r -> !r.isFull())
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getWithoutPetType(PetType... petTypes) {
        return getAll().stream()
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
