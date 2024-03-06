package com.anagornii.learning.javacodetrack.controller;

import com.anagornii.learning.javacodetrack.controller.dto.CreateBlogPostRequest;
import com.anagornii.learning.javacodetrack.controller.dto.CreateBlogPostResponse;
import com.anagornii.learning.javacodetrack.controller.dto.GetBlogPostByIdResponse;
import com.anagornii.learning.javacodetrack.controller.dto.GetBlogPostsResponse;
import com.anagornii.learning.javacodetrack.service.post.BlogPostCreationService;
import com.anagornii.learning.javacodetrack.service.post.BlogPostDeletionService;
import com.anagornii.learning.javacodetrack.service.post.BlogPostRetrievalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * This class is a REST controller that handles HTTP requests related to blog posts.
 * It uses the {@link BlogPostCreationService},
 * {@link BlogPostRetrievalService}, and
 * {@link BlogPostDeletionService} to perform operations related to blog posts.
 *
 * <p>It provides the following endpoints:
 * <ul>
 *     <li>GET /api/blog-posts: Retrieves all blog posts.</li>
 *     <li>GET /api/blog-posts/{id}: Retrieves a blog post by its ID.</li>
 *     <li>POST /api/blog-posts: Creates a new blog post.</li>
 *     <li>DELETE /api/blog-posts/{id}: Deletes a blog post by its ID.</li>
 * </ul>
 *
 * @author anagornaia
 * @version 2023.3.4
 * @since 1.0
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/blog-posts")
public class BlogPostController {

    private final BlogPostCreationService blogPostCreationService;
    private final BlogPostRetrievalService blogPostRetrievalService;
    private final BlogPostDeletionService blogPostDeletionService;

    @GetMapping
    public GetBlogPostsResponse getAllBlogPosts() {
        log.info("Retrieving all blog posts");
        return blogPostRetrievalService.getAllBlogPosts();
    }

    @GetMapping("/{id}")
    public GetBlogPostByIdResponse getBlogPostById(@PathVariable Long id) {
        log.info("Retrieving blog post with ID: {}", id);
        return blogPostRetrievalService.getBlogPostById(id);
    }

    @PostMapping
    public CreateBlogPostResponse createBlogPost(@RequestBody CreateBlogPostRequest post) {
        log.info("Creating a new blog post, with data {}", post);
        return blogPostCreationService.createBlogPost(post);
    }

    @DeleteMapping("/{id}")
    public Long deleteBlogPost(@PathVariable Long id) {
        log.info("Deleting blog post with ID: {}", id);
        return blogPostDeletionService.deleteBlogPost(id);
    }
}