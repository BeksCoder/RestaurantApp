package sultan.is.restaurantapp.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import sultan.is.restaurantapp.dto.request.CategoryRequest;
import sultan.is.restaurantapp.dto.response.CategoryResponse;
import sultan.is.restaurantapp.dto.response.SimpleResponse;
import sultan.is.restaurantapp.services.CategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/categories")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class CategoryController {
    CategoryService categoryService;

    @PostMapping("/save")
    public SimpleResponse save(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.saveCategory(categoryRequest);
    }

    @GetMapping("/categories")
    public Page<CategoryResponse> getCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        log.info("Fetching categories: page={}, size={}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        Page<CategoryResponse> categories = categoryService.findAllCategories(pageable);
        log.info("Fetched {} categories", categories.getTotalElements());
        return categories;
    }
    @GetMapping("/{id}")
    public CategoryResponse getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }


}
