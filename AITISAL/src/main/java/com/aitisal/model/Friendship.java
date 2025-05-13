package main.java.com.aitisal.model;

import jakarta.persistence.*;

@Entity
public class Friendship {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User from;
    @ManyToOne
    private User to;

    // getters & setters
}