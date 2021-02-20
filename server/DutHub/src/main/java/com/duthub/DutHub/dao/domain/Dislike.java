package com.duthub.DutHub.dao.domain;

import javax.persistence.*;

@Entity
@Table(name = "dislikes")
public class Dislike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @Transient
    private String userId;

    @ManyToOne
    @JoinColumn(name="video_id", nullable=false)
    private Video video;
    @Transient
    private Long videoId;

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


    public String getUserId() {
        if (user != null)
            return user.getId();
        else
            return userId;
    }

    public Long getVideoId() {
        if (video != null)
            return video.getId();
        else
            return videoId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }
}