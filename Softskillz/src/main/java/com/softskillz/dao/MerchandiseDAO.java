package com.softskillz.dao;

import com.softskillz.models.Merchandise;
import com.softskillz.util.DatabaseUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MerchandiseDAO {
    private DataSource dataSource;

    public MerchandiseDAO() {
        this.dataSource = DatabaseUtil.getDataSource();
    }

    public List<Merchandise> getAllMerchandises() {
        List<Merchandise> merchandises = new ArrayList<>();
        String sql = "SELECT * FROM merchandise";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Merchandise merchandise = new Merchandise();
                merchandise.setMerchandiseId(resultSet.getInt("merchandise_id"));
                merchandise.setProductId(resultSet.getInt("product_id"));
                merchandise.setMerchandiseName(resultSet.getString("merchandise_name"));
                merchandise.setMerchandisePrice(resultSet.getInt("merchandise_price"));
                merchandise.setMerchandiseStockQuantity(resultSet.getInt("merchandise_stock_quantity"));
                merchandise.setMerchandiseDescription(resultSet.getString("merchandise_description"));
                merchandise.setMerchandiseImageUrl(resultSet.getString("merchandise_image_url"));
                merchandises.add(merchandise);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return merchandises;
    }

    public boolean addMerchandise(Merchandise merchandise) {
        String sql = "INSERT INTO merchandise (product_id, merchandise_name, merchandise_price, merchandise_stock_quantity, merchandise_description, merchandise_image_url) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, merchandise.getProductId());
            statement.setString(2, merchandise.getMerchandiseName());
            statement.setInt(3, merchandise.getMerchandisePrice());
            statement.setInt(4, merchandise.getMerchandiseStockQuantity());
            statement.setString(5, merchandise.getMerchandiseDescription());
            statement.setString(6, merchandise.getMerchandiseImageUrl());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateMerchandise(Merchandise merchandise) {
        String sql = "UPDATE merchandise SET product_id=?, merchandise_name=?, merchandise_price=?, merchandise_stock_quantity=?, merchandise_description=?, merchandise_image_url=? WHERE merchandise_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, merchandise.getProductId());
            statement.setString(2, merchandise.getMerchandiseName());
            statement.setInt(3, merchandise.getMerchandisePrice());
            statement.setInt(4, merchandise.getMerchandiseStockQuantity());
            statement.setString(5, merchandise.getMerchandiseDescription());
            statement.setString(6, merchandise.getMerchandiseImageUrl());
            statement.setInt(7, merchandise.getMerchandiseId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMerchandise(int merchandiseId) {
        String sql = "DELETE FROM merchandise WHERE merchandise_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, merchandiseId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
