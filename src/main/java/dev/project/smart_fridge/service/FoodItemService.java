package dev.project.smart_fridge.service;

import dev.project.smart_fridge.model.FoodItem;
import dev.project.smart_fridge.repository.FoodItemRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepo foodItemRepository;

    public FoodItemService(FoodItemRepo foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public FoodItem save(FoodItem foodItem) {
        validateFoodItem(foodItem);
        return foodItemRepository.save(foodItem);
    }

    public List<FoodItem> findAll() {
        return foodItemRepository.findAll();
    }

    public Optional<FoodItem> findById(Long id) {
        return foodItemRepository.findById(id);
    }

    public void delete(Long id) {
        foodItemRepository.deleteById(id);
    }

    private void validateFoodItem(FoodItem foodItem) {
        if (!StringUtils.hasText(foodItem.getName())) {
            throw new IllegalArgumentException("O nome do alimento não pode ser nulo ou vazio.");
        }

        if (foodItem.getQuantity() == null || foodItem.getQuantity() <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }

        if (foodItem.getCategory() == null) {
            throw new IllegalArgumentException("A categoria não pode ser nula.");
        }
    }
}
