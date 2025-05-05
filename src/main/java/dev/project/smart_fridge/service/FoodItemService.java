package dev.project.smart_fridge.service;

import dev.project.smart_fridge.repository.FoodItemRepo;
import org.springframework.stereotype.Service;

@Service
public class FoodItemService {

    private final FoodItemRepo repository;

    public FoodItemService(FoodItemRepo repository) {
        this.repository = repository;
    }

}
