package sultan.is.restaurantapp.services.impl;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sultan.is.restaurantapp.dto.request.SubCategoryRequest;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import sultan.is.restaurantapp.dto.response.SubcategoryResponse;
import sultan.is.restaurantapp.entities.Category;
import sultan.is.restaurantapp.entities.SubCategory;
import sultan.is.restaurantapp.exceptions.ResourceNotFoundException;
import sultan.is.restaurantapp.mapper.SubCategoryMapper;
import sultan.is.restaurantapp.repositories.CategoryRepository;
import sultan.is.restaurantapp.repositories.SubCategoryRepository;
import sultan.is.restaurantapp.services.SubCategoryService;

import java.util.List;


@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubCategoryImpl implements SubCategoryService {
    CategoryRepository categoryRepository;
    SubCategoryRepository subCategoryRepository;
    SubCategoryMapper subCategoryMapper;


    @Override
    public SimpleResponse addSubCategoryToCategory(Long categoryId, SubCategoryRequest subCategoryRequest) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id " + categoryId + " not found"));
        SubCategory subCategory = subCategoryMapper.toEntity(subCategoryRequest);
        subCategory.setCategory(category);
        subCategoryRepository.save(subCategory);
        log.info("successfully added to category");
        return SimpleResponse.builder()
                .status(HttpStatus.CREATED)
                .description("success")
                .build();
    }

    @Override
    public List<SubcategoryResponse> findSubCategoryByCategoryId(Long id) {
        Sort sort = Sort.by(Sort.Order.asc("name"));
        List<SubCategory> subCategories = subCategoryRepository.findByCategoryId(id,sort);
        return subCategoryMapper.toSubCategoryResponse(subCategories);
    }

    @Override
    public SubcategoryResponse findById(Long id) {
       SubCategory subCategory =  subCategoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        String.format("Subcategory with id %d not found",id)));
       return subCategoryMapper.toSubCategoryResponse(subCategory);
    }

    @Override
    public SimpleResponse updateSubCategory(Long id, SubCategoryRequest subCategoryRequest) {
        subCategoryRepository.updateSubCategoryById(id,subCategoryRequest);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .description("success")
                .build();


    }

    @Override
    public Page<SubcategoryResponse> findAllSubCategories(Pageable pageable) {
        Page<SubCategory> subCategories = subCategoryRepository.findAll(pageable);
        return subCategories.map(subCategoryMapper::toSubCategoryResponse);

    }
}
