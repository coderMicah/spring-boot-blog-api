package com.micah.posts.domain.dtos;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.micah.posts.domain.entities.Post;

public record TagDto(UUID id, String name, Set<Post> posts, LocalDateTime createdAt, LocalDateTime updatedAt) {

}
