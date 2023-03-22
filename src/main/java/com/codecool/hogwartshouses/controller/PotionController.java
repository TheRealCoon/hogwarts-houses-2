package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.enums.Ingredient;
import com.codecool.hogwartshouses.service.PotionService;
import com.codecool.hogwartshouses.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/potions")
public class PotionController {
    private final PotionService potionService;
    private final StudentService studentService;

    public PotionController(PotionService potionService, StudentService studentService) {
        this.potionService = potionService;
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllRecipes(Model model) {
        model.addAttribute("recipes", potionService.getAllRecipes());
        return "recipes";
    }

    @GetMapping("/{studentId}")
    public String getRecipesKnownByStudent(@PathVariable long studentId, Model model) {
        model.addAttribute("allIngredients", Ingredient.getStringValues());
        model.addAttribute("student", studentService.getById(studentId));
        return "student_recipes";
    }

    @PostMapping("/{studentId}")
    public String addRecipeCreatedByStudent(
            @PathVariable long studentId,
            @RequestParam("name") String name,
            @RequestParam("potion_ingredients") List<String> ingredients,
            @RequestHeader("Referer") String referer) {
        if (!potionService.isPotionUnique(ingredients)) {
            System.out.println("Wrong recipe!");
            return "/{studentId}";
        } else {
            potionService.add(studentId, name, ingredients);
            return "redirect:" + referer;
        }
    }
}
