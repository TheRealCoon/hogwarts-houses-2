package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/rooms")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getAll(Model model) {

        //TODO delete this, this is just example data
        Room room = roomService.getAll().stream()
                .filter(r -> r.getId() == 1)
                .collect(Collectors.toList())
                .get(0);
        room.addStudent(Student.builder().name("Pisti").houseType(HouseType.RAVENCLAW).petType(PetType.NONE).build());
        room.addStudent(Student.builder().name("Zoli").houseType(HouseType.RAVENCLAW).petType(PetType.NONE).build());
        room.addStudent(Student.builder().name("Csabi").houseType(HouseType.RAVENCLAW).petType(PetType.NONE).build());
        //TODO delete till here

        model.addAttribute("rooms", roomService.getAll());
        return "rooms";
    }

    @PostMapping
    public String addRoom(Model model){
        roomService.addRoom(Room.builder().build()); //todo add houseType to Room maybe
        model.addAttribute("rooms", roomService.getAll());
        return "rooms";
    }
}
