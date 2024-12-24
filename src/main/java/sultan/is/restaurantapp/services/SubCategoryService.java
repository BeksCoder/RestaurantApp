package sultan.is.restaurantapp.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sultan.is.restaurantapp.dto.request.SubCategoryRequest;
import sultan.is.restaurantapp.dto.response.CategoryResponse;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import sultan.is.restaurantapp.dto.response.SubcategoryResponse;

import java.util.List;

public interface SubCategoryService {

     SimpleResponse addSubCategoryToCategory(Long categoryId , SubCategoryRequest subCategoryRequest);

     List<SubcategoryResponse>  findSubCategoryByCategoryId(Long id);

     SubCategoryService findById(Long id);

     SimpleResponse updateSubCategory(Long id,SubCategoryRequest subCategoryRequest);

     Page<CategoryResponse> findAllSubCategories(Pageable pageable);






}
