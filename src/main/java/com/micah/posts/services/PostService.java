package com.micah.posts.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.micah.posts.domain.entities.Post;

public interface PostService {

    Page<Post> getAllPosts(Pageable pageable);

}
