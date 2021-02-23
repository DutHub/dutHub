package com.duthub.DutHub.bll.domain.dto;

import com.duthub.DutHub.dao.domain.Video;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class VideoDto {
    public VideoDto(Video video){
        this.id = video.getId();
        this.userId = video.getUser().getId();
        this.userUsername = video.getUser().getUsername();
        this.title = video.getTitle();
        this.description = video.getDescription();
        this.creationDate = video.getCreationDate();
        this.likes = video.getLikes().size();
        this.dislikes = video.getDislikes().size();
        this.videoPath = video.getVideoPath();
        this.previewPath = video.getPreviewPath();
        this.views = video.getViews();
        this.comments = video.getComments().size();
    }

    private Long id;
    private String userId;
    private String userUsername;
    private String title;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm dd-MM-yyyy")
    private LocalDateTime creationDate;
    private int likes;
    private int dislikes;
    private String videoPath;
    private String previewPath;
    private int views;
    private int comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getPreviewPath() {
        return previewPath;
    }

    public void setPreviewPath(String previewPath) {
        this.previewPath = previewPath;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getUserId() {
            return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }
}
