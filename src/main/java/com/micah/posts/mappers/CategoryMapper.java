package com.micah.posts.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.micah.posts.domain.dtos.CategoryRequestDto;
import com.micah.posts.domain.dtos.CategoryResponseDto;
import com.micah.posts.domain.entities.Category;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryResponseDto toCategoryResponseDto(Category category);

    Category fromCategoryRequestDto(CategoryRequestDto categoryRequest);

}
