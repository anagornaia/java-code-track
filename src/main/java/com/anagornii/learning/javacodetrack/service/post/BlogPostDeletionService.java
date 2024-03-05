package com.anagornii.learning.javacodetrack.service.post;

import com.anagornii.learning.javacodetrack.exception.ExceptionType;
import com.anagornii.learning.javacodetrack.exception.JavaCodeTrackException;
import com.anagornii.learning.javacodetrack.persistance.model.BlogPostEntity;
import com.anagornii.learning.javacodetrack.persistance.repository.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This service class is responsible for deleting blog posts.
 * It uses the BlogPostRepository for fetching the blog post and marking it as deleted.
 *
 * @author anagornaia
 * @version 2023.3.4
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class BlogPostDeletionService {

    private final BlogPostRepository blogPostRepository;

    /**
     * This method is responsible for deleting a blog post by its ID.
     * It fetches the BlogPostEntity with the given ID that is not marked as deleted using the BlogPostRepository,
     * and then marks the fetched BlogPostEntity as deleted.
     *
     * @param id the ID of the blog post to delete.
     * @return the ID of the deleted blog post.
     */
    @Transactional
    public Long deleteBlogPost(Long id) {
        BlogPostEntity blogPostEntity = blogPostRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> JavaCodeTrackException.of(ExceptionType.POST_NOT_FOUND));
        blogPostEntity.setDeleted(true);
        return blogPostEntity.getId();
    }
}