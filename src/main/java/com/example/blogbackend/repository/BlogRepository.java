package com.example.blogbackend.repository;

import com.example.blogbackend.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Ensure this exists
    Page<Blog> findAll(Pageable pageable);
}
