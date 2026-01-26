package com.micah.posts.domain.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDto(@NotBlank(message = "Event name is required") String name) {

}
