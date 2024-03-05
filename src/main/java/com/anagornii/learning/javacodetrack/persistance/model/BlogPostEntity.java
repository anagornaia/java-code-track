package com.anagornii.learning.javacodetrack.persistance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter

@Entity
@Table(name = "t_blog_post")
public class BlogPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blogpost_seq")
    @SequenceGenerator(name = "blogpost_seq", sequenceName = "t_blog_post_seq" , allocationSize = 10)
    private Long id;
    private String title;
    private String content;
    @CurrentTimestamp
    private LocalDateTime createdAt;
    private boolean deleted;

}