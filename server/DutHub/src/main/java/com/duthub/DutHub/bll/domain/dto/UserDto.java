package com.duthub.DutHub.bll.domain.dto;

import com.duthub.DutHub.dao.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class UserDto {
    public UserDto(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.picturePath = user.getPicturePath();
        this.email = user.getEmail();
        this.locale = user.getLocale();
        this.lastVisit = user.getLastVisit();
        this.videoAmount = user.getVideos().size();
    }

    private String id;
    private String username;
    private String picturePath;
    private String email;
    private String locale;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm dd-MM-yyyy")
    private LocalDateTime lastVisit;
    private int videoAmount;

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

    public LocalDateTime getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDateTime lastVisit) {
        this.lastVisit = lastVisit;
    }

    public int getVideoAmount() {
        return videoAmount;
    }

    public void setVideoAmount(int videoAmount) {
        this.videoAmount = videoAmount;
    }
}
