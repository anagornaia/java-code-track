package com.anagornii.learning.javacodetrack.persistance.repository;

import com.anagornii.learning.javacodetrack.persistance.model.BlogPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This interface extends JpaRepository to provide CRUD operations for {@link com.anagornii.learning.javacodetrack.persistance.model.BlogPostEntity}.
 * It includes additional methods to find blog posts that are not marked as deleted.
 *
 * @author anagornaia
 * @version 2023.3.4
 * @since 1.0
 */
@Repository
public interface BlogPostRepository extends JpaRepository<BlogPostEntity, Long> {

    /**
     * Retrieves a blog post by its ID if it's not marked as deleted.
     *
     * @param id the ID of the blog post to retrieve.
     * @return an Optional containing the blog post if found, or an empty Optional if not found or marked as deleted.
     */
    @Query("SELECT p FROM BlogPostEntity p WHERE p.deleted = false AND p.id = :id")
    Optional<BlogPostEntity> findByIdAndDeletedFalse(Long id);

    /**
     * Retrieves all blog posts that are not marked as deleted.
     *
     * @return a List of blog posts that are not marked as deleted.
     */
    @Query("SELECT p FROM BlogPostEntity p WHERE p.deleted = false")
    List<BlogPostEntity> findAllAndDeletedFalse();
}