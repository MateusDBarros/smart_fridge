package dev.project.smart_fridge;

import dev.project.smart_fridge.model.Category;
import dev.project.smart_fridge.model.FoodItem;
import dev.project.smart_fridge.repository.FoodItemRepo;
import dev.project.smart_fridge.service.FoodItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FoodItemServiceTest {

    private FoodItemRepo foodItemRepository;
    private FoodItemService foodItemService;

    @BeforeEach
    void setUp() {
        foodItemRepository = mock(FoodItemRepo.class);
        foodItemService = new FoodItemService(foodItemRepository);
    }

    @Test
    void shouldSaveValidFoodItem() {
        FoodItem item = new FoodItem(null, "Leite", 2, Category.BEBIDA);
        when(foodItemRepository.save(any(FoodItem.class))).thenReturn(item);

        FoodItem saved = foodItemService.save(item);

        ArgumentCaptor<FoodItem> captor = ArgumentCaptor.forClass(FoodItem.class);
        verify(foodItemRepository).save(captor.capture());
        assertEquals("Leite", captor.getValue().getName());
        assertEquals(saved, item);
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        FoodItem item = new FoodItem(null, null, 1, Category.CARNE);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            foodItemService.save(item);
        });

        assertEquals("O nome do alimento não pode ser nulo ou vazio.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenQuantityIsZero() {
        FoodItem item = new FoodItem(null, "Frango", 0, Category.CARNE);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            foodItemService.save(item);
        });

        assertEquals("A quantidade deve ser maior que zero.", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenCategoryIsNull() {
        FoodItem item = new FoodItem(null, "Frango", 1, null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            foodItemService.save(item);
        });

        assertEquals("A categoria não pode ser nula.", exception.getMessage());
    }

    @Test
    void shouldFindById() {
        FoodItem item = new FoodItem(1L, "Maçã", 3, Category.FRUTA);
        when(foodItemRepository.findById(1L)).thenReturn(Optional.of(item));

        Optional<FoodItem> result = foodItemService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("Maçã", result.get().getName());
    }
}
