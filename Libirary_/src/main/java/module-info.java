module com.example.libirary_ {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.libirary_ to javafx.fxml;
    exports com.example.libirary_;
}