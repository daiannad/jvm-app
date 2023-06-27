package com.example.finalexample.data;

import javafx.scene.chart.PieChart;

import java.net.ConnectException;
import java.sql.*;
public class DataBase {

    private static String DB_URL = "dbc:mysql://db_ip:3306/finals_prep";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    private static Connection connection = null;

    private DataBase() { };


    public static Connection getConnection() throws SQLException {
        if(connection == null){
            connection =DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }
        return connection;
    }

    public static void createProductTable() throws SQLException {
        String createTableQueryCommand = "CREATE TABLE IF NOT EXISTS products" +
                "(id INT PRIMARY KEY AUTO INCREMENT, " +
                "NAME VARCHAR(50), " +
                "COUNT INT)";

        getConnection().createStatement().execute(createTableQueryCommand);
    }
}
