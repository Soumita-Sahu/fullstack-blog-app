package com.example.blogbackend.mapper;

import com.example.blogbackend.dto.BlogResponse;
import com.example.blogbackend.entity.Blog;

public class BlogMapper {
    public static BlogResponse toBlogResponse(Blog blog) {
        return BlogResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .authorEmail(blog.getAuthor().getEmail())
                .createdAt(blog.getCreatedAt())
                .build();
    }
}
