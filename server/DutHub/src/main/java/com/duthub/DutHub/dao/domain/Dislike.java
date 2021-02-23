package com.duthub.DutHub.dao.domain;

import javax.persistence.*;

@Entity
@Table(name = "dislikes")
public class Dislike {
    public Dislike(){}

    public Dislike(User user, Video video){
        this.user = user;
        this.video = video;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="video_id", nullable=false)
    private Video video;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}