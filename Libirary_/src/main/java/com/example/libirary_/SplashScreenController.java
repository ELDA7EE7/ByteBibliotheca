package com.example.libirary_;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreenController implements Initializable {

    @FXML
    private StackPane rootpane;
    @FXML
    private ImageView loadingImageView;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootpane = new StackPane(); // Initialize rootpane
        new SplashScreen().start();
    }

    class SplashScreen extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                Platform.runLater(() -> {
                    Parent root = null;
                    try {
                       root = FXMLLoader.load(getClass().getResource("LogInAsUserScene.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                   // Stage stage = new Stage();
                    stage = (Stage) (loadingImageView).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setFullScreen(true);
                    stage.show();

                    // Check if rootpane is not null before using it
                    if (rootpane != null && rootpane.getScene() != null) {
                        rootpane.getScene().getWindow().hide();
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
