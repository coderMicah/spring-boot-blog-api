package com.micah.posts.domain.dtos;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record PostResponseDto(UUID id, String title, String content, UserResponseDto user, CategoryResponseDto category,
        Set<TagResponseDto> tags, LocalDateTime createdAt, LocalDateTime updatedAt) {

}
