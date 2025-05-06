package dev.project.smart_fridge.controller;

import dev.project.smart_fridge.model.FoodItem;
import dev.project.smart_fridge.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-items")
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping
    public ResponseEntity<FoodItem> create(@RequestBody FoodItem foodItem) {
        FoodItem saved = foodItemService.save(foodItem);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<FoodItem>> findAll() {
        return ResponseEntity.ok(foodItemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> findById(@PathVariable Long id) {
        return foodItemService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        foodItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
