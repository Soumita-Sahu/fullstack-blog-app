package com.example.blogbackend.service;
import com.example.blogbackend.dto.BlogResponse;
import com.example.blogbackend.entity.Blog;
import com.example.blogbackend.entity.User;
import com.example.blogbackend.mapper.BlogMapper;
import com.example.blogbackend.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogResponse createBlog(String title, String content, User author) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setAuthor(author);

        Blog savedBlog = blogRepository.save(blog);

        // Convert to DTO before returning
        return mapToBlogResponse(savedBlog);
    }
    public Page<BlogResponse> getAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable)
                .map(this::mapToBlogResponse); // Convert each Blog to BlogResponse
    }

    private BlogResponse mapToBlogResponse(Blog blog) {
        return BlogResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .content(blog.getContent())
                .authorEmail(blog.getAuthor().getEmail())
                .createdAt(blog.getCreatedAt())
                .build();
    }
}
