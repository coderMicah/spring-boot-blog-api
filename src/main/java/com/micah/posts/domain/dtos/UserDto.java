package com.micah.posts.domain.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.micah.posts.domain.entities.Post;

public record UserDto(UUID id, String name, String email, List<Post> posts, LocalDateTime createdAt,
        LocalDateTime updatedAt) {

}
