package com.softskillz.dao;

import com.softskillz.models.Coupon;
import com.softskillz.util.DatabaseUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CouponDAO {

    private DataSource dataSource;

    public CouponDAO() {
        this.dataSource = DatabaseUtil.getDataSource();
    }

    public List<Coupon> getAllCoupons() {
        List<Coupon> coupons = new ArrayList<>();
        String sql = "SELECT * FROM coupon";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Coupon coupon = new Coupon();
                coupon.setCouponId(resultSet.getInt("coupon_id"));
                coupon.setCouponCode(resultSet.getString("coupon_code"));
                coupon.setCouponDescription(resultSet.getString("coupon_description"));
                coupon.setCouponUsageLimit(resultSet.getInt("coupon_usage_limit"));
                coupon.setCouponUsageStatus(resultSet.getString("coupon_usage_status"));
                coupon.setCouponValidFrom(resultSet.getTimestamp("coupon_valid_from").toLocalDateTime());
                if (resultSet.getTimestamp("coupon_valid_to") != null) {
                    coupon.setCouponValidTo(resultSet.getTimestamp("coupon_valid_to").toLocalDateTime());
                }
                coupon.setCouponDiscount(resultSet.getInt("coupon_discount"));
                coupon.setCouponDiscountType(resultSet.getString("coupon_discount_type"));
                coupon.setCouponConditions(resultSet.getString("coupon_conditions"));
                coupons.add(coupon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coupons;
    }

    public boolean addCoupon(Coupon coupon) {
        String sql = "INSERT INTO coupon (coupon_code, coupon_description, coupon_usage_limit, coupon_usage_status, coupon_valid_from, coupon_valid_to, coupon_discount, coupon_discount_type, coupon_conditions) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, coupon.getCouponCode());
            statement.setString(2, coupon.getCouponDescription());
            statement.setInt(3, coupon.getCouponUsageLimit());
            statement.setString(4, coupon.getCouponUsageStatus());
            statement.setTimestamp(5, java.sql.Timestamp.valueOf(coupon.getCouponValidFrom()));
            statement.setTimestamp(6, coupon.getCouponValidTo() == null ? null : java.sql.Timestamp.valueOf(coupon.getCouponValidTo()));
            statement.setInt(7, coupon.getCouponDiscount());
            statement.setString(8, coupon.getCouponDiscountType());
            statement.setString(9, coupon.getCouponConditions());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCoupon(Coupon coupon) {
        String sql = "UPDATE coupon SET coupon_code=?, coupon_description=?, coupon_usage_limit=?, coupon_usage_status=?, coupon_valid_from=?, coupon_valid_to=?, coupon_discount=?, coupon_discount_type=?, coupon_conditions=? WHERE coupon_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, coupon.getCouponCode());
            statement.setString(2, coupon.getCouponDescription());
            statement.setInt(3, coupon.getCouponUsageLimit());
            statement.setString(4, coupon.getCouponUsageStatus());
            statement.setTimestamp(5, java.sql.Timestamp.valueOf(coupon.getCouponValidFrom()));
            statement.setTimestamp(6, coupon.getCouponValidTo() == null ? null : java.sql.Timestamp.valueOf(coupon.getCouponValidTo()));
            statement.setInt(7, coupon.getCouponDiscount());
            statement.setString(8, coupon.getCouponDiscountType());
            statement.setString(9, coupon.getCouponConditions());
            statement.setInt(10, coupon.getCouponId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCoupon(int couponId) {
        String sql = "DELETE FROM coupon WHERE coupon_id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, couponId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
