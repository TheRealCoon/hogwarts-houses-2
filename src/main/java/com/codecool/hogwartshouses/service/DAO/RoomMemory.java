package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.model.types.RoomCondition;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class RoomMemory implements RoomDAO {

    private Set<Room> rooms;

    public RoomMemory(Set<Room> rooms) {
        this.rooms = rooms;
        initialize();
    }

    private void initialize(){
        //TODO delete this method, this is just example data
        Room room = Room.builder().build();
        rooms.add(room);
        room.addStudent(Student.builder().name("Pisti").houseType(HouseType.RAVENCLAW).petType(PetType.NONE).build());
        room.addStudent(Student.builder().name("Zoli").houseType(HouseType.RAVENCLAW).petType(PetType.NONE).build());
        room.addStudent(Student.builder().name("Csabi").houseType(HouseType.RAVENCLAW).petType(PetType.NONE).build());
        //TODO delete till here
    }

    @Override
    public Set<Room> getAll() {
        return rooms;
    }

    @Override
    public void add(Room room) {
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
        //todo could be a boolean to know if there was something deleted or no
        rooms.removeIf(r -> r.getId() == id);
    }

    @Override
    public void renovate(int id) {
        findById(id).setRoomCondition(RoomCondition.RENOVATED);
    }
}
