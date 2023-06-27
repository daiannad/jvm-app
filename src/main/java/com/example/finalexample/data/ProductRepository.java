package com.example.finalexample.data;

import javafx.scene.chart.PieChart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    
    public void addProducts(Product product) throws SQLException {
        String addProductCommand = "INSERT INTO products(name, count) VALUES(?, ?)";
        PreparedStatement addProductPreparedStatement = DataBase.getConnection().prepareStatement(addProductCommand);
        addProductPreparedStatement.setString(1,product.getName());
        addProductPreparedStatement.setInt(2,product.getCount());
        addProductPreparedStatement.executeUpdate();
    }
    
    public List<Product> getAllProducts() throws SQLException {
        String getProuctsCommand = "SELECT * FROM PRODUCTS";
        ResultSet productsResultSet = DataBase.getConnection().createStatement().executeQuery(getProuctsCommand);

        ArrayList<Product> productArrayList = new ArrayList<>();

        while (productsResultSet.next()){
            int id = productsResultSet.getInt("id");
            String name = productsResultSet.getString("name");
            int count = productsResultSet.getInt("count");

            Product product = new Product(id, name, count);
            productArrayList.add(product);
        }
        return productArrayList;
    }
}
