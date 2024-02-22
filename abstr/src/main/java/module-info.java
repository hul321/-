module com.example.abstr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.abstr to javafx.fxml;
    exports com.example.abstr;
}