package com.anagornii.learning.javacodetrack.service.post;

import com.anagornii.learning.javacodetrack.controller.dto.blog.post.CreateBlogPostRequest;
import com.anagornii.learning.javacodetrack.controller.dto.blog.post.CreateBlogPostResponse;
import com.anagornii.learning.javacodetrack.mapper.BlogPostEntityMapper;
import com.anagornii.learning.javacodetrack.mapper.CreateBlogPostResponseMapper;
import com.anagornii.learning.javacodetrack.persistance.model.BlogPostEntity;
import com.anagornii.learning.javacodetrack.persistance.repository.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * This service class is responsible for creating blog posts.
 * It uses the BlogPostRepository for saving the blog post,
 * PostEntityMapper for mapping the request to the BlogPostEntity,
 * and CreateBlogPostResponseMapper for mapping the saved BlogPostEntity to the response.
 *
 * @author anagornaia
 * @version 2023.3.4
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class BlogPostCreationService {

    private final BlogPostRepository blogPostRepository;
    private final BlogPostEntityMapper blogPostEntityMapper;
    private final CreateBlogPostResponseMapper createBlogPostResponseMapper;

    /**
     * This method is responsible for creating a blog post.
     *
     * @param request the CreateBlogPostRequest containing the data for the blog post to be created.
     * @return a CreateBlogPostResponse containing the data of the created blog post.
     */
    public CreateBlogPostResponse createBlogPost(CreateBlogPostRequest request) {
        BlogPostEntity blogPostEntity = blogPostEntityMapper.toEntity(request);
        var savedBlogPost = blogPostRepository.save(blogPostEntity);
        return createBlogPostResponseMapper.toResponse(savedBlogPost);
    }
}