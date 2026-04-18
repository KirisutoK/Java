module com.example.csc195_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc195_javafx to javafx.fxml;
    exports com.example.csc195_javafx;
}