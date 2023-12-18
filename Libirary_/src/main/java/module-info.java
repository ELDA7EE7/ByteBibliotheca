module com.example.libirary_ {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.libirary_ to javafx.fxml;
    exports searchengine;
    exports com.example.libirary_;

    opens searchengine to javafx.fxml;
    exports AdminPackage;
    opens AdminPackage to javafx.fxml;
    exports InterfacesPackage;
    opens InterfacesPackage to javafx.fxml;
    exports userprofile;
    opens userprofile to javafx.fxml;
    exports registrationsystem;
    opens registrationsystem to javafx.fxml;
    exports datastructure.trie;
    opens datastructure.trie to javafx.fxml;

    exports UsersOfLibrary;
    opens UsersOfLibrary to javafx.fxml;
}