package com.micah.posts.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.micah.posts.domain.entities.Category;

public interface CategoryService {

    Page<Category> listAllCategories(Pageable pageable);

    Category createCategory(Category category);

    Category updateCategory(UUID categoryId, Category category);

    void deleteCategory(UUID categoryId);
}
