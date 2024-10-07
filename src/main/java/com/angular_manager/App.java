package com.angular_manager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import com.angular_manager.view.MainScene;

/**
 * JavaFX App
 */
public class App extends Application {

    // private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        // For now the app will have only one scene
        Scene mainScene = MainScene.createMainScene();

        // Sets some Stage's properties and assigns the scene to it
        stage.setTitle("Angular Desktop Manager");
        stage.getIcons().add(new Image("file:src/main/resources/images/icon.png"));
        stage.setScene(mainScene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}