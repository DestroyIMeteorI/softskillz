package com.softskillz.models;

import java.time.LocalDateTime;

public class TutorialVideo {
    private Long videoId;
    private Long productId; // 對應於SQL的product_id欄位
    private String videoTitle; // SQL中為video_title
    private String videoThumbnailUrl; // SQL中為video_thumbnail_url
    private String videoUrl; // SQL中為video_url
    private String videoDescription; // SQL中為video_description
    private LocalDateTime videoUploadDate; // 已經正確使用了LocalDateTime

    // Getters and Setters
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
