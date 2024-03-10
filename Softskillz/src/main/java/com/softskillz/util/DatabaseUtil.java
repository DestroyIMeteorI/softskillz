package com.softskillz.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseUtil {
    public static DataSource getDataSource() {
        DataSource dataSource = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/softskillzDB");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}