package sultan.is.restaurantapp.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sultan.is.restaurantapp.dto.request.CategoryRequest;
import sultan.is.restaurantapp.entities.Category;
import sultan.is.restaurantapp.exceptions.AlreadyExistsException;
import sultan.is.restaurantapp.repositories.CategoryRepository;
import sultan.is.restaurantapp.services.CategoryService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void saveCategory_whenCategoryAlreadyExists_shouldThrowException() {

}
    @Test
    void findAllCategories() {
    }

    @Test
    void getById() {
    }

    @Test
    void updateCategoryById() {
    }

    @Test
    void deleteById() {
    }
}