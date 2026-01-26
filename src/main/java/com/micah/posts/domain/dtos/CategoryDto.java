package com.micah.posts.domain.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.micah.posts.domain.entities.Post;

public record CategoryDto(UUID id, String name, List<Post> posts, LocalDateTime createdAt, LocalDateTime updatedAt) {

}
