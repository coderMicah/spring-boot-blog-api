package com.micah.posts.domain.dtos;

import java.util.Set;
import java.util.UUID;

public record TagResponseDto(UUID id, String name, Set<PostResponseDto> posts) {

}
