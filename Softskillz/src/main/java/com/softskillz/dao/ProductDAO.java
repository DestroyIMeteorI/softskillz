package com.softskillz.dao;

import com.softskillz.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection connection;

    public ProductDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("product_id"));
                product.setProductName(resultSet.getString("product_name"));
                product.setProductDescription(resultSet.getString("product_description"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setProductPrice(resultSet.getDouble("product_price")); // 修正為getDouble
                product.setProductStock(resultSet.getInt("product_stock"));
                product.setProductImageUrl(resultSet.getString("product_image_url"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductById(int productId) {
        String sql = "SELECT * FROM product WHERE product_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Product product = new Product();
                    product.setProductId(resultSet.getInt("product_id"));
                    product.setProductName(resultSet.getString("product_name"));
                    product.setProductDescription(resultSet.getString("product_description"));
                    product.setCategoryId(resultSet.getInt("category_id"));
                    product.setProductPrice(resultSet.getDouble("product_price")); // 修正為getDouble
                    product.setProductStock(resultSet.getInt("product_stock"));
                    product.setProductImageUrl(resultSet.getString("product_image_url"));
                    return product;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addProduct(Product product) {
        String sql = "INSERT INTO product (product_name, product_description, category_id, product_price, product_stock, product_image_url) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getProductDescription());
            statement.setInt(3, product.getCategoryId());
            statement.setDouble(4, product.getProductPrice()); // 使用setDouble而非setInt
            statement.setInt(5, product.getProductStock());
            statement.setString(6, product.getProductImageUrl());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        String sql = "UPDATE product SET product_name=?, product_description=?, category_id=?, product_price=?, product_stock=?, product_image_url=? WHERE product_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getProductName());
            statement.setString(2, product.getProductDescription());
            statement.setInt(3, product.getCategoryId());
            statement.setDouble(4, product.getProductPrice()); // 同样使用setDouble
            statement.setInt(5, product.getProductStock());
            statement.setString(6, product.getProductImageUrl());
            statement.setInt(7, product.getProductId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProduct(int productId) {
        String sql = "DELETE FROM product WHERE product_id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
