package com.softskillz.dao;

import com.softskillz.models.TutorialVideo;
import com.softskillz.util.DatabaseUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TutorialVideoDAO {
    private DataSource dataSource;

    public TutorialVideoDAO() {
        this.dataSource = DatabaseUtil.getDataSource();
    }

    // 獲取所有教學視頻
    public List<TutorialVideo> getAllTutorialVideos() {
        List<TutorialVideo> videos = new ArrayList<>();
        String sql = "SELECT * FROM tutorialvideo";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videos;
    }

    // 添加新的教學視頻
    public boolean addTutorialVideo(TutorialVideo video) {
        String sql = "INSERT INTO tutorialvideo (product_id, video_title, video_thumbnail_url, video_url, video_description, video_upload_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, video.getProductId());
            statement.setString(2, video.getVideoTitle());
            statement.setString(3, video.getVideoThumbnailUrl());
            statement.setString(4, video.getVideoUrl());
            statement.setString(5, video.getVideoDescription());
            statement.setTimestamp(6, Timestamp.valueOf(video.getVideoUploadDate()));
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新教學視頻
    public boolean updateTutorialVideo(TutorialVideo video) {
        String sql = "UPDATE tutorialvideo SET product_id=?, video_title=?, video_thumbnail_url=?, video_url=?, video_description=?, video_upload_date=? WHERE video_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, video.getProductId());
            statement.setString(2, video.getVideoTitle());
            statement.setString(3, video.getVideoThumbnailUrl());
            statement.setString(4, video.getVideoUrl());
            statement.setString(5, video.getVideoDescription());
            statement.setTimestamp(6, Timestamp.valueOf(video.getVideoUploadDate()));
            statement.setLong(7, video.getVideoId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 刪除教學視頻
    public boolean deleteTutorialVideo(Long videoId) {
        String sql = "DELETE FROM tutorialvideo WHERE video_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, videoId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
