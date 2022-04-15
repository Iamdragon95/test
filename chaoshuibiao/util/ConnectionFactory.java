package com.chaoshuibiao.util;

import com.mysql.jdbc.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author iamdragon
 * @version 1.0
 */
public class ConnectionFactory {
    private static Connection connection;
    private static PreparedStatement preparedStatement;


    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\GrootProject\\chaoshuibiao\\src\\mysql.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }


}
