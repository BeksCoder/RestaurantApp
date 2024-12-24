package sultan.is.restaurantapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sultan.is.restaurantapp.dto.request.CategoryRequest;
import sultan.is.restaurantapp.dto.response.CategoryResponse;
import sultan.is.restaurantapp.entities.Category;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "subcategories", source = "subcategories")
    CategoryResponse toCategoryResponse(Category category);


    Category toCategory(CategoryRequest request);

    List<CategoryResponse> toCategoryResponse(List<Category> categories);
}

