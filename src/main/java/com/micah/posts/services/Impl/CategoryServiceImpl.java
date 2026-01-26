package com.micah.posts.services.Impl;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.micah.posts.domain.entities.Category;
import com.micah.posts.exceptions.DuplicateResourceException;
import com.micah.posts.exceptions.ResourceNotFoundException;
import com.micah.posts.repository.CategoryRepository;
import com.micah.posts.services.CategoryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Page<Category> listAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category createCategory(Category category) {
        if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
            throw new DuplicateResourceException("Category", "name", category.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category updateCategory(UUID categoryId, Category category) {

        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", category.getId()));

        if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
            throw new DuplicateResourceException("Category", "name", category.getName());
        }

        existingCategory.setName(category.getName());

        // No save() needed — JPA dirty checking handles it
        return existingCategory;
    }

    @Override
    @Transactional
    public void deleteCategory(UUID categoryId) {
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));
        categoryRepository.deleteById(existingCategory.getId());
    }

}
