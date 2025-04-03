package com.example.blogbackend.controller;

import com.example.blogbackend.dto.BlogRequest;
import com.example.blogbackend.dto.BlogResponse;
import com.example.blogbackend.entity.User;
import com.example.blogbackend.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<Page<BlogResponse>> getAllBlogs(Pageable pageable) {
        return ResponseEntity.ok(blogService.getAllBlogs(pageable));
    }

    @PostMapping
    public ResponseEntity<BlogResponse> createBlog(
            @RequestBody BlogRequest request,
            Authentication authentication // Inject authentication
    ) {
        User currentUser = (User) authentication.getPrincipal(); // Get logged-in user
        return ResponseEntity.ok(
                blogService.createBlog(request.getTitle(), request.getContent(), currentUser)
        );
    }
}