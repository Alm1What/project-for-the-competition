package org.example.projectforthecompetition.entity;

import jakarta.persistence.*;
import org.example.projectforthecompetition.Enum.ERole;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @OneToMany(mappedBy = "author")
    private List<Course> createdCourses;

    @OneToMany(mappedBy = "author")
    private List<Article> articles;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

}
