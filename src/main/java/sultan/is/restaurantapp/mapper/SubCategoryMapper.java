package sultan.is.restaurantapp.mapper;

import org.mapstruct.Mapper;
import sultan.is.restaurantapp.dto.request.SubCategoryRequest;
import sultan.is.restaurantapp.dto.response.CategoryResponse;
import sultan.is.restaurantapp.dto.response.SubcategoryResponse;
import sultan.is.restaurantapp.entities.SubCategory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {

    SubCategory toEntity(SubCategoryRequest subCategoryRequest);

    SubcategoryResponse toSubCategoryResponse(SubCategory subCategory);

    List<SubcategoryResponse> toSubCategoryResponse(List<SubCategory> subCategories);



}
