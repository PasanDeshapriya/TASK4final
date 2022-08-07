module com.example.task4final {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task4final to javafx.fxml;
    exports com.example.task4final;
}