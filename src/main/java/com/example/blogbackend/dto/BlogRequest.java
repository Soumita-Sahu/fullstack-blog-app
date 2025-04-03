package com.example.blogbackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BlogRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
