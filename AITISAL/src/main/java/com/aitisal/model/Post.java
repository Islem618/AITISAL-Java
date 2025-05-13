package main.java.com.aitisal.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User author;
    private String content;
    private boolean isPublic;
    private LocalDateTime created = LocalDateTime.now();

    // getters & setters
}