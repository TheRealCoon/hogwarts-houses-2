package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.service.PotionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/potions")
public class PotionController {
    private final PotionService service;

    public PotionController(PotionService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllRecipes(Model model){
        model.addAttribute("recipes", service.getAllRecipes());
        return "recipes";
    }
}
