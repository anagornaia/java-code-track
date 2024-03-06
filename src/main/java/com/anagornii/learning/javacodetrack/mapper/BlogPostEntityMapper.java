package com.anagornii.learning.javacodetrack.mapper;

import com.anagornii.learning.javacodetrack.controller.dto.blog.post.CreateBlogPostRequest;
import com.anagornii.learning.javacodetrack.persistance.model.BlogPostEntity;
import org.springframework.stereotype.Component;

@Component
public class BlogPostEntityMapper {

    public BlogPostEntity toEntity(CreateBlogPostRequest createBlogPostRequest) {
        var blogPostEntity = new BlogPostEntity();
        blogPostEntity.setTitle(createBlogPostRequest.getTitle());
        blogPostEntity.setContent(createBlogPostRequest.getContent());
        return blogPostEntity;
    }
}
