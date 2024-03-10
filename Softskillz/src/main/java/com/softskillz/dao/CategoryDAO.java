package com.softskillz.dao;

import com.softskillz.models.Category;
import com.softskillz.util.DatabaseUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private DataSource dataSource;

    public CategoryDAO() {
        this.dataSource = DatabaseUtil.getDataSource();
    }

    // 取得所有分類
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setCategoryName(resultSet.getString("category_name"));
                category.setCategoryDescription(resultSet.getString("category_description"));
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    // 依照ID取得單一分類
    public Category getCategoryById(int categoryId) {
        String sql = "SELECT * FROM category WHERE category_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, categoryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Category category = new Category();
                    category.setCategoryId(resultSet.getInt("category_id"));
                    category.setCategoryName(resultSet.getString("category_name"));
                    category.setCategoryDescription(resultSet.getString("category_description"));
                    return category;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 新增分類
    public boolean addCategory(Category category) {
        String sql = "INSERT INTO category (category_name, category_description) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getCategoryDescription());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新分類
    public boolean updateCategory(Category category) {
        String sql = "UPDATE category SET category_name=?, category_description=? WHERE category_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getCategoryDescription());
            statement.setInt(3, category.getCategoryId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 刪除分類
    public boolean deleteCategory(int categoryId) {
        String sql = "DELETE FROM category WHERE category_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, categoryId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
