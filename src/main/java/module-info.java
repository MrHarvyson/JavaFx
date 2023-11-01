module com.example.inicio_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.inicio_javafx to javafx.fxml;
    exports com.example.inicio_javafx;
}