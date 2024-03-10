package com.softskillz.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;

public class DatabaseUtil {
    private static DataSource dataSource;

    static {
        try {
            // 建立 c3p0 連線池實例
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // 設定 JDBC 驅動
            cpds.setJdbcUrl("jdbc:sqlserver://localhost:1433;databaseName=softskillzdb;encrypt=false"); // 設定資料庫 URL
            cpds.setUser("meteor2"); // 設定資料庫用戶名
            cpds.setPassword("1397"); // 設定資料庫密碼

            // 以下是一些連線池的可選設定
            cpds.setInitialPoolSize(5); // 初始連線池大小
            cpds.setMinPoolSize(5); // 最小連線池大小
            cpds.setAcquireIncrement(5); // 當連線池中的連線不足時，一次增加多少個連線
            cpds.setMaxPoolSize(20); // 最大連線池大小
            cpds.setMaxStatements(100); // JDBC 的 statement Pooling 功能

            dataSource = cpds;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
