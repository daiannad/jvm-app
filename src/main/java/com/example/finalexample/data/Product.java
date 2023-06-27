package com.example.finalexample.data;

import javafx.scene.chart.PieChart;

public class Product {
    private final int id;

    private final String name;
    private final int count;

    public Product(int id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }



    public int getCount() {
        return count;
    }


    public PieChart.Data toChartData() {
        return new PieChart.Data(name, count);
    }
}
