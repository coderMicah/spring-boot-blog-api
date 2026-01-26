package com.micah.posts.domain.dtos;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.micah.posts.domain.entities.Category;
import com.micah.posts.domain.entities.Tag;
import com.micah.posts.domain.entities.User;

public record PostDto(UUID id, String title, String content, User user, Category category, Set<Tag> tags,
        LocalDateTime createdAt, LocalDateTime updatedAt) {
}