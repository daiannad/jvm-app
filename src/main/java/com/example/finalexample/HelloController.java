package com.example.finalexample;

import com.example.finalexample.data.DataBase;
import com.example.finalexample.data.Product;
import com.example.finalexample.data.ProductRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.net.ssl.X509KeyManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class HelloController implements Initializable {

    ProductRepository repository = new ProductRepository();
    @FXML
    public PieChart productChart;

    @FXML
    public TextField nameField;

    @FXML
    public TextField countField;
    @FXML
    public void onSaveClick() {
        String name = nameField.getText();
        int count = parseInt(countField.getText());

        Product product = new Product(0, name, count);

        try {
            repository.addProducts(product);
            List<Product> productList = repository.getAllProducts();
            productChart.setData(
                    FXCollections.observableArrayList(
                            productList.stream().map(Product::toChartData)
                                    .collect(Collectors.toList())
                    )
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            try {
                DataBase.createProductTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}