module com.example.iterator_lab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task4 to javafx.fxml;
    exports com.example.task4;
}