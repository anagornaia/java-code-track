package com.anagornii.learning.javacodetrack.service.post;

import com.anagornii.learning.javacodetrack.controller.dto.GetBlogPostByIdResponse;
import com.anagornii.learning.javacodetrack.controller.dto.GetBlogPostsResponse;
import com.anagornii.learning.javacodetrack.exception.ExceptionType;
import com.anagornii.learning.javacodetrack.exception.JavaCodeTrackException;
import com.anagornii.learning.javacodetrack.mapper.GetBlogPostByIdResponseMapper;
import com.anagornii.learning.javacodetrack.mapper.GetBlogPostsResponseMapper;
import com.anagornii.learning.javacodetrack.persistance.model.BlogPostEntity;
import com.anagornii.learning.javacodetrack.persistance.repository.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service class is responsible for retrieving blog posts.
 * It uses the BlogPostRepository for fetching the blog posts,
 * GetPostByIdResponseMapper for mapping the fetched BlogPostEntity to the response for a single post,
 * and GetPostsResponseMapper for mapping the list of fetched BlogPostEntities to the response for multiple posts.
 *
 * @author anagornaia
 * @version 2023.3.4
 * @since 1.0
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class BlogPostRetrievalService {

    private final BlogPostRepository blogPostRepository;
    private final GetBlogPostByIdResponseMapper getBlogPostByIdResponseMapper;
    private final GetBlogPostsResponseMapper getBlogPostsResponseMapper;

    /**
     * This method is responsible for retrieving all blog posts.
     * It fetches all BlogPostEntities that are not marked as deleted using the BlogPostRepository,
     * and then maps the list of fetched BlogPostEntities to a GetBlogPostsResponse.
     *
     * @return a GetBlogPostsResponse containing the data of all retrieved blog posts.
     */
    public GetBlogPostsResponse getAllBlogPosts() {
        List<BlogPostEntity> postEntities = blogPostRepository.findAllAndDeletedFalse();
        log.info("Found {} blog posts", postEntities.size());
        return getBlogPostsResponseMapper.toResponse(postEntities);
    }

    /**
     * This method is responsible for retrieving a single blog post by its ID.
     * It fetches the BlogPostEntity with the given ID that is not marked as deleted using the BlogPostRepository,
     * and then maps the fetched BlogPostEntity to a GetBlogPostByIdResponse.
     *
     * @param id the ID of the blog post to retrieve.
     * @return a GetBlogPostByIdResponse containing the data of the retrieved blog post.
     */
    public GetBlogPostByIdResponse getBlogPostById(Long id) {
        var referenceById = blogPostRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> JavaCodeTrackException.of(ExceptionType.POST_NOT_FOUND));
        return getBlogPostByIdResponseMapper.toResponse(referenceById);
    }
}