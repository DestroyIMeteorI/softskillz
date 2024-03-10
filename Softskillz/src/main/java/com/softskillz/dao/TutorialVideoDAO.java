package com.softskillz.dao;

import com.softskillz.models.TutorialVideo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TutorialVideoDAO {
    private Connection connection;

    public TutorialVideoDAO(Connection connection) {
        this.connection = connection;
    }

    // 獲取所有教學視頻
    public List<TutorialVideo> getAllTutorialVideos() throws SQLException {
        List<TutorialVideo> videos = new ArrayList<>();
        String sql = "SELECT * FROM tutorialvideo";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                TutorialVideo video = new TutorialVideo();
                video.setVideoId(resultSet.getLong("video_id"));
                video.setProductId(resultSet.getLong("product_id"));
                video.setVideoTitle(resultSet.getString("video_title"));
                video.setVideoThumbnailUrl(resultSet.getString("video_thumbnail_url"));
                video.setVideoUrl(resultSet.getString("video_url"));
                video.setVideoDescription(resultSet.getString("video_description"));
                video.setVideoUploadDate(resultSet.getTimestamp("video_upload_date").toLocalDateTime());
                videos.add(video);
            }
        }
        return videos;
    }

    // 添加新的教學視頻
    public boolean addTutorialVideo(TutorialVideo video) throws SQLException {
        String sql = "INSERT INTO tutorialvideo (product_id, video_title, video_thumbnail_url, video_url, video_description, video_upload_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, video.getProductId());
            statement.setString(2, video.getVideoTitle());
            statement.setString(3, video.getVideoThumbnailUrl());
            statement.setString(4, video.getVideoUrl());
            statement.setString(5, video.getVideoDescription());
            statement.setTimestamp(6, Timestamp.valueOf(video.getVideoUploadDate()));
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    // 更新教學視頻
    public boolean updateTutorialVideo(TutorialVideo video) throws SQLException {
        String sql = "UPDATE tutorialvideo SET product_id=?, video_title=?, video_thumbnail_url=?, video_url=?, video_description=?, video_upload_date=? WHERE video_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, video.getProductId());
            statement.setString(2, video.getVideoTitle());
            statement.setString(3, video.getVideoThumbnailUrl());
            statement.setString(4, video.getVideoUrl());
            statement.setString(5, video.getVideoDescription());
            statement.setTimestamp(6, Timestamp.valueOf(video.getVideoUploadDate()));
            statement.setLong(7, video.getVideoId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    // 刪除教學視頻
    public boolean deleteTutorialVideo(Long videoId) throws SQLException {
        String sql = "DELETE FROM tutorialvideo WHERE video_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, videoId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
}
