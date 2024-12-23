package sultan.is.restaurantapp.services;

import sultan.is.restaurantapp.dto.request.CategoryRequest;
import sultan.is.restaurantapp.dto.response.CategoryResponse;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import java.util.List;
public interface CategoryService {
    SimpleResponse saveCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> findAllCategories();

    CategoryResponse getById(Long id);

    SimpleResponse updateCategoryById(Long id, CategoryRequest categoryRequest);

    SimpleResponse deleteById(Long id);

}
