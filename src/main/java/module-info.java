module com.example.finalexample {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.finalexample to javafx.fxml;
    exports com.example.finalexample;
}