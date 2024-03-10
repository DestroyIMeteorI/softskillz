package com.softskillz.dao;

import com.softskillz.models.PhysicalBook;
import com.softskillz.util.DatabaseUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhysicalBookDAO {
    private DataSource dataSource;

    public PhysicalBookDAO() {
        this.dataSource = DatabaseUtil.getDataSource();
    }

    public List<PhysicalBook> getAllPhysicalBooks() {
        List<PhysicalBook> books = new ArrayList<>();
        String sql = "SELECT * FROM physicalbook";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                PhysicalBook book = new PhysicalBook();
                book.setBookId(resultSet.getInt("book_id"));
                book.setProductId(resultSet.getInt("product_id"));
                book.setBookTitle(resultSet.getString("book_title"));
                book.setBookAuthor(resultSet.getString("book_author"));
                book.setBookIsbn(resultSet.getString("book_isbn"));
                book.setBookPrice(resultSet.getInt("book_price"));
                book.setBookStockQuantity(resultSet.getInt("book_stock_quantity"));
                book.setBookDescription(resultSet.getString("book_description"));
                book.setBookPublishDate(resultSet.getDate("book_publish_date").toLocalDate());
                book.setBookImageUrl(resultSet.getString("book_image_url"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public boolean addPhysicalBook(PhysicalBook book) {
        String sql = "INSERT INTO physicalbook (product_id, book_title, book_author, book_isbn, book_price, book_stock_quantity, book_description, book_publish_date, book_image_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, book.getProductId());
            statement.setString(2, book.getBookTitle());
            statement.setString(3, book.getBookAuthor());
            statement.setString(4, book.getBookIsbn());
            statement.setInt(5, book.getBookPrice());
            statement.setInt(6, book.getBookStockQuantity());
            statement.setString(7, book.getBookDescription());
            statement.setDate(8, Date.valueOf(book.getBookPublishDate()));
            statement.setString(9, book.getBookImageUrl());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePhysicalBook(PhysicalBook book) {
        String sql = "UPDATE physicalbook SET product_id=?, book_title=?, book_author=?, book_isbn=?, book_price=?, book_stock_quantity=?, book_description=?, book_publish_date=?, book_image_url=? WHERE book_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, book.getProductId());
            statement.setString(2, book.getBookTitle());
            statement.setString(3, book.getBookAuthor());
            statement.setString(4, book.getBookIsbn());
            statement.setInt(5, book.getBookPrice());
            statement.setInt(6, book.getBookStockQuantity());
            statement.setString(7, book.getBookDescription());
            statement.setDate(8, Date.valueOf(book.getBookPublishDate()));
            statement.setString(9, book.getBookImageUrl());
            statement.setInt(10, book.getBookId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePhysicalBook(int bookId) {
        String sql = "DELETE FROM physicalbook WHERE book_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bookId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
