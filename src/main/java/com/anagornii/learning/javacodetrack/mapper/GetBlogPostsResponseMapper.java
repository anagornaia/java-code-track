package com.anagornii.learning.javacodetrack.mapper;

import com.anagornii.learning.javacodetrack.controller.dto.blog.post.BlogPostData;
import com.anagornii.learning.javacodetrack.controller.dto.blog.post.GetBlogPostsResponse;
import com.anagornii.learning.javacodetrack.persistance.model.BlogPostEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class GetBlogPostsResponseMapper {

    public GetBlogPostsResponse toResponse(List<BlogPostEntity> posts) {
        var blogPostDataList = posts.stream().map(this::toPostData).collect(toList());
        var response = new GetBlogPostsResponse();
        response.setPosts(blogPostDataList);
        return response;
    }

    private BlogPostData toPostData(BlogPostEntity post) {
        var blogPostData = new BlogPostData();
        blogPostData.setId(post.getId());
        blogPostData.setTitle(post.getTitle());
        blogPostData.setContent(post.getContent());
        blogPostData.setCreatedAt(post.getCreatedAt());
        return blogPostData;
    }
}
