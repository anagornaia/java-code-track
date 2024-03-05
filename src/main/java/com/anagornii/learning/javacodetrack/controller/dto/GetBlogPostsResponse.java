package com.anagornii.learning.javacodetrack.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetBlogPostsResponse {
    List<BlogPostData> posts;
}
