package com.hillel.hw20.dbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    public static Connection getConnection() throws SQLException, IOException {
        String url = "jdbc:mysql://localhost:3306/homelibrary?allowPublicKeyRetrieval=true&useSSL=false";

        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "12345678");
        prop.put("useSSL", "false");
        prop.put("serverTimezone", "UTC");
        prop.put("characterEncoding", "UTF-8");
        return DriverManager.getConnection(url, prop);

    }
}