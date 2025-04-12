package org.example.projectforthecompetition.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private LocalDateTime createdAt;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Module module;

    @ManyToOne
    private Comment parent;

    @OneToMany(mappedBy = "parent")
    private List<Comment> replies;

    public Comment() {
    }

    public Comment(Long id, String text, LocalDateTime createdAt, User user, Course course, Module module, Comment parent, List<Comment> replies) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
        this.user = user;
        this.course = course;
        this.module = module;
        this.parent = parent;
        this.replies = replies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }
}
