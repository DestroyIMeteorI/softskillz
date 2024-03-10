package com.softskillz.models;

import java.time.LocalDateTime;

public class TutorialVideo {
    private Long videoId;
    private Long productId; 
    private String videoTitle; 
    private String videoThumbnailUrl; 
    private String videoUrl; 
    private String videoDescription; 
    private LocalDateTime videoUploadDate; 

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoThumbnailUrl() {
        return videoThumbnailUrl;
    }

    public void setVideoThumbnailUrl(String videoThumbnailUrl) {
        this.videoThumbnailUrl = videoThumbnailUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    public LocalDateTime getVideoUploadDate() {
        return videoUploadDate;
    }

    public void setVideoUploadDate(LocalDateTime videoUploadDate) {
        this.videoUploadDate = videoUploadDate;
    }
}
