package com.micah.posts.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micah.posts.domain.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    boolean existsByNameIgnoreCase(String name);

}
