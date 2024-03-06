package com.anagornii.learning.javacodetrack.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogPostData {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
