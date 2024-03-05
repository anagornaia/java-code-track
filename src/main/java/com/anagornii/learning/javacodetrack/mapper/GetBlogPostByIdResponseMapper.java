package com.anagornii.learning.javacodetrack.mapper;

import com.anagornii.learning.javacodetrack.controller.dto.GetBlogPostByIdResponse;
import com.anagornii.learning.javacodetrack.persistance.model.BlogPostEntity;
import org.springframework.stereotype.Component;

@Component
public class GetBlogPostByIdResponseMapper {

    public GetBlogPostByIdResponse toResponse(BlogPostEntity blogPostEntity) {
        var getBlogPostByIdResponse = new GetBlogPostByIdResponse();
        getBlogPostByIdResponse.setId(blogPostEntity.getId());
        getBlogPostByIdResponse.setTitle(blogPostEntity.getTitle());
        getBlogPostByIdResponse.setContent(blogPostEntity.getContent());
        getBlogPostByIdResponse.setCreatedAt(blogPostEntity.getCreatedAt());
        return getBlogPostByIdResponse;
    }
}
