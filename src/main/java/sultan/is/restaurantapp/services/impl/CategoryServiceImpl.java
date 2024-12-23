package sultan.is.restaurantapp.services.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sultan.is.restaurantapp.dto.request.CategoryRequest;
import sultan.is.restaurantapp.dto.response.CategoryResponse;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import sultan.is.restaurantapp.entities.Category;
import sultan.is.restaurantapp.exceptions.AlreadyExistsException;
import sultan.is.restaurantapp.exceptions.ResourceNotFoundException;
import sultan.is.restaurantapp.mapper.CategoryMapper;
import sultan.is.restaurantapp.repositories.CategoryRepository;
import sultan.is.restaurantapp.services.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public SimpleResponse saveCategory(CategoryRequest categoryRequest) {
        List<Category> all = categoryRepository.findAll();
        for (Category category : all) {
            if (category.getName().contains(categoryRequest.name())) {
                throw new AlreadyExistsException(String.format("Category with name %s already exists", categoryRequest.name()));
            }
        }
       Category category =  categoryMapper.toCategory(categoryRequest);
        categoryRepository.save(category);
        return SimpleResponse.builder().status(HttpStatus.CREATED).build();
    }

    @Override
    public List<CategoryResponse> findAllCategories() {
        return null;
    }

    @Override
    public CategoryResponse getById(Long id) {
        Category category =  categoryRepository.findById(id).stream().findFirst()
                 .orElseThrow(()-> new ResourceNotFoundException(String.format("Category with id %d not found",id)));
        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public SimpleResponse updateCategoryById(Long id, CategoryRequest categoryRequest) {
       Category category =  categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Category with id %d not found",id)));

       category.setName(categoryRequest.name());
       categoryRepository.save(category);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .description(String.format("Category with id %d successfully updated", id))
                .build();
    }

    @Override
    public SimpleResponse deleteById(Long id) {
         categoryRepository.deleteById(id);
         return SimpleResponse.builder().status(HttpStatus.OK).description("deleted").build();

    }
}
