package com.banque.services.core.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnection {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Error(e);
        }
    }

    static Connection get() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://18.116.202.27:3306/COREBANKING", "root", "a@2021JP");
    }
}
