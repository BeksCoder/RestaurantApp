package sultan.is.restaurantapp.services;

import sultan.is.restaurantapp.dto.request.CategoryRequest;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import sultan.is.restaurantapp.entities.Category;
import java.util.List;
public interface CategoryService {
    SimpleResponse saveCategory(CategoryRequest categoryRequest);

    List<Category> findAllCategories();

    Category getById(Long id);

    SimpleResponse updateCategoryById(Long id, CategoryRequest categoryRequest);

    SimpleResponse deleteById(Long id);

}
