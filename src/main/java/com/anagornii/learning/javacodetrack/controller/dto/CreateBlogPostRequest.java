package com.anagornii.learning.javacodetrack.controller.dto;

import lombok.Data;

@Data
public class CreateBlogPostRequest {
    private String title;
    private String content;
}
