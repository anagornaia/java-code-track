package com.anagornii.learning.javacodetrack.controller.dto.blog.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetBlogPostByIdResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
