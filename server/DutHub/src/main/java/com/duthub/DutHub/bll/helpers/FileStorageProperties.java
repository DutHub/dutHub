package com.duthub.DutHub.bll.helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    @Value("${file.upload-vid-dir}")
    private String uploadVideoDir;
    @Value("${file.upload-pre-dir}")
    private String uploadPreviewDir;

    public String getUploadVideoDir() {
        return uploadVideoDir;
    }

    public void setUploadVideoDir(String uploadVideoDir) {
        this.uploadVideoDir = uploadVideoDir;
    }

    public String getUploadPreviewDir() {
        return uploadPreviewDir;
    }

    public void setUploadPreviewDir(String uploadPreviewDir) {
        this.uploadPreviewDir = uploadPreviewDir;
    }
}
