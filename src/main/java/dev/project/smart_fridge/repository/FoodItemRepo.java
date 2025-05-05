package dev.project.smart_fridge.repository;

import dev.project.smart_fridge.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, Long> {
}
