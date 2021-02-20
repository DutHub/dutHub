package com.duthub.DutHub.dao.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private String id;
    private String username;
    private String picturePath;
    private String email;
    private String locale;

    @OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private Set<Video> videos;

    @OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private Set<Comment> comments;

    @OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private Set<Like> likes;

    @OneToMany(mappedBy="user", fetch = FetchType.EAGER)
    private Set<Dislike> dislikes;

    @Column(updatable = false)
    private LocalDateTime lastVisit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Set<Video> getVideos() {
        return videos;
    }

    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    public Set<Dislike> getDislikes() {
        return dislikes;
    }

    public void setDislikes(Set<Dislike> dislikes) {
        this.dislikes = dislikes;
    }

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }
}

