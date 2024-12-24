package sultan.is.restaurantapp.services.impl;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sultan.is.restaurantapp.dto.request.CategoryRequest;
import sultan.is.restaurantapp.dto.response.CategoryResponse;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import sultan.is.restaurantapp.entities.Category;
import sultan.is.restaurantapp.exceptions.ResourceNotFoundException;
import sultan.is.restaurantapp.mapper.CategoryMapper;
import sultan.is.restaurantapp.repositories.CategoryRepository;
import sultan.is.restaurantapp.services.CategoryService;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;


    @Override
    public SimpleResponse saveCategory(CategoryRequest categoryRequest) {
        categoryRepository.findByName(categoryRequest.name())
                .ifPresent(category -> {
                    log.error("Category with name {} already exists", categoryRequest.name());
                });
        Category category = categoryMapper.toCategory(categoryRequest);
        categoryRepository.save(category);
        log.info("Category with name {} successfully saved", categoryRequest.name());
        return SimpleResponse.builder()
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    public Page<CategoryResponse> findAllCategories(Pageable pageable) {
        Page<Category> categoriesPage = categoryRepository.findAll(pageable);
        return categoriesPage.map(categoryMapper::toCategoryResponse);
    }

    @Override
    public CategoryResponse getById(Long id) {
        Category category = categoryRepository.findById(id).stream().findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Category with id %d not found", id)));
        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public SimpleResponse updateCategoryById(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Category with id %d not found", id)));

        category.setName(categoryRequest.name());
        categoryRepository.save(category);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .description(String.format("Category with id %d successfully updated", id))
                .build();
    }

    @Override
    public SimpleResponse deleteById(Long id) {
        categoryRepository.findById(id).ifPresentOrElse(
                category -> {
                    categoryRepository.deleteById(id);
                    log.info("Category with id {} successfully deleted", id);
                },
                () -> {
                    log.error("Category with id {} not found", id);
                    throw new ResourceNotFoundException(String.format("Category with id %d not found", id));
                }
        );
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .description(String.format("Category with id %d successfully deleted", id))
                .build();
    }
}

