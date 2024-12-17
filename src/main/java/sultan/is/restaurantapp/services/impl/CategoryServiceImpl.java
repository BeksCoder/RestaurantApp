package sultan.is.restaurantapp.services.impl;

import org.springframework.stereotype.Service;
import sultan.is.restaurantapp.dto.request.CategoryRequest;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import sultan.is.restaurantapp.entities.Category;
import sultan.is.restaurantapp.repositories.CategoryRepository;
import sultan.is.restaurantapp.services.CategoryService;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

   private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SimpleResponse saveCategory(CategoryRequest categoryRequest) {
        
        categoryRepository.save()

        return null;
    }

    @Override
    public List<Category> findAllCategories() {
        return List.of();
    }

    @Override
    public Category getById(Long id) {
        return null;
    }

    @Override
    public SimpleResponse updateCategoryById(Long id, CategoryRequest categoryRequest) {
        return null;
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        return null;
    }
}
