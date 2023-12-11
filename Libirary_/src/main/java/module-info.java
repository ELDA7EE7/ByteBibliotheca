module com.example.libirary_ {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.libirary_ to javafx.fxml;
    exports SearchEngine;
    exports com.example.libirary_;

    opens SearchEngine to javafx.fxml;
    exports AdminPackage;
    opens AdminPackage to javafx.fxml;
    exports InterfacesPackage;
    opens InterfacesPackage to javafx.fxml;
}