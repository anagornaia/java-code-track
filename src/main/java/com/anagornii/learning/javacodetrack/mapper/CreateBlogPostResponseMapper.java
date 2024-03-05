package com.anagornii.learning.javacodetrack.mapper;

import com.anagornii.learning.javacodetrack.controller.dto.CreateBlogPostResponse;
import com.anagornii.learning.javacodetrack.persistance.model.BlogPostEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateBlogPostResponseMapper {

    public CreateBlogPostResponse toResponse(BlogPostEntity blogPostEntity) {
        var createBlogPostResponse = new CreateBlogPostResponse();
        createBlogPostResponse.setId(blogPostEntity.getId());
        return createBlogPostResponse;
    }
}
