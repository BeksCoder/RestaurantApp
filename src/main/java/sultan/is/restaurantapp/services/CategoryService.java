package sultan.is.restaurantapp.services;

import org.springframework.data.domain.Page;
import sultan.is.restaurantapp.dto.request.CategoryRequest;
import sultan.is.restaurantapp.dto.response.CategoryResponse;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import org.springframework.data.domain.Pageable;
public interface CategoryService {
    SimpleResponse saveCategory(CategoryRequest categoryRequest);

    Page<CategoryResponse> findAllCategories(Pageable pageable);

    CategoryResponse getById(Long id);

    SimpleResponse updateCategoryById(Long id, CategoryRequest categoryRequest);

    SimpleResponse deleteById(Long id);

}
