package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("rooms", roomService.getAll());
        return "rooms";
    }

    @PostMapping
    public String add(){
        roomService.add(Room.builder().build()); //todo add houseType, RoomCondition to Room
        return "redirect:/rooms";
    }

    @GetMapping("/{roomId}")
    public String findById(@PathVariable("roomId") int id, Model model){
        Room room = roomService.findById(id);
        model.addAttribute("room", room);
        return "room";
    }

    @DeleteMapping("/{roomId}")
    public String delete(@PathVariable("roomId") int id){
        roomService.delete(id); //todo could be a boolean to know if there was something deleted or no
        return "redirect:/rooms";
    }

    @PutMapping("/{roomId}")
    public String renovate(@PathVariable("roomId") int id){
        //TODO add RoomCondtion enum to Room, update room's condition to RENOVATED
        return "redirect:/rooms";
    }
}
