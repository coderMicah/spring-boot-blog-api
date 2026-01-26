package com.micah.posts.controllers;

import java.net.URI;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micah.posts.domain.dtos.CategoryRequestDto;
import com.micah.posts.domain.dtos.CategoryResponseDto;
import com.micah.posts.domain.entities.Category;
import com.micah.posts.mappers.CategoryMapper;
import com.micah.posts.services.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper mapper;

    @GetMapping
    public ResponseEntity<Page<CategoryResponseDto>> listAllCategories(Pageable pageable) {
        Page<Category> categories = categoryService.listAllCategories(pageable);
        Page<CategoryResponseDto> categoriesResponse = categories
                .map(category -> mapper.toCategoryResponseDto(category));
        return ResponseEntity.ok(categoriesResponse);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@Valid @RequestBody CategoryRequestDto categoryRequest) {
        Category category = mapper.fromCategoryRequestDto(categoryRequest);
        Category createdCategory = categoryService.createCategory(category);
        CategoryResponseDto response = mapper.toCategoryResponseDto(createdCategory);

        URI location = URI.create("/api/v1/categories/" + createdCategory.getId());
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping(path = "/{categoryId}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@Valid @RequestBody CategoryRequestDto categoryRequest,
            @PathVariable UUID categoryId) {

        Category category = mapper.fromCategoryRequestDto(categoryRequest);
        Category updatedCategory = categoryService.updateCategory(categoryId, category);

        return ResponseEntity.ok(mapper.toCategoryResponseDto(updatedCategory));

    }

    @DeleteMapping(path = "/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID categoryId) {

        categoryService.deleteCategory(categoryId);

        return ResponseEntity.noContent().build();
    }
}
