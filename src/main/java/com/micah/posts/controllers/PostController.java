package com.micah.posts.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micah.posts.domain.dtos.PostResponseDto;
import com.micah.posts.domain.entities.Post;
import com.micah.posts.mappers.PostMapper;
import com.micah.posts.services.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    @GetMapping
    public ResponseEntity<Page<PostResponseDto>> getAllPosts(Pageable pageable) {
        Page<Post> posts = postService.getAllPosts(pageable);
        Page<PostResponseDto> postsResponse = posts.map(post -> postMapper.toPostResponseDto(post));
        return ResponseEntity.ok(postsResponse);
    }
}
