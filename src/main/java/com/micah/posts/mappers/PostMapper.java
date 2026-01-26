package com.micah.posts.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.micah.posts.domain.dtos.PostResponseDto;
import com.micah.posts.domain.dtos.TagResponseDto;
import com.micah.posts.domain.dtos.UserResponseDto;
import com.micah.posts.domain.entities.Post;
import com.micah.posts.domain.entities.Tag;
import com.micah.posts.domain.entities.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostResponseDto toPostResponseDto(Post post);

    TagResponseDto toTagResponseDto(Tag tag);

    UserResponseDto toUserResponseDto(User user);

    // CategoryResponseDto toCategoryResponseDto(Category category);

    // Category fromCategoryRequestDto(CategoryRequestDto categoryRequestDto);
}