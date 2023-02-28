package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.model.types.RoomCondition;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/rooms")
public class RoomController {
    private final RoomService roomService;

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
    public String add(@RequestParam("houseType") HouseType houseType,
                      @RequestParam("roomCondition") RoomCondition roomCondition) {
        roomService.add(Room.builder().houseType(houseType).roomCondition(roomCondition).build());
        return "redirect:/rooms";
    }

    @GetMapping("/{roomId}")
    public String findById(@PathVariable("roomId") int id, Model model) {
        Room room = roomService.findById(id);
        model.addAttribute("room", room);
        return "room";
    }

    @DeleteMapping("/{roomId}")
    public String delete(@PathVariable("roomId") int id) {
        roomService.delete(id);
        return "redirect:/rooms";
    }

    @PutMapping("/{roomId}")
    public String renovate(@PathVariable("roomId") int id, @RequestHeader("Referer") String referer) {
        roomService.renovate(id);
        return "redirect:" + referer;
    }

    @GetMapping("/available")
    public String getAllAvailable(Model model){
        model.addAttribute("title", "Rooms available");
        model.addAttribute("rooms", roomService.getAllAvailable());
        return "filtered_rooms";
    }

    @GetMapping("/rat-owners")
    public String getAllRatFriendly(Model model){
        model.addAttribute("title", "Rooms for rat-owners");
        model.addAttribute("rooms", roomService.getWithoutPetType(PetType.CAT, PetType.OWL));
        return "filtered_rooms";
    }

}
