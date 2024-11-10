package com.angular_manager.view.stage;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.Desktop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AboutDialog extends Stage {
    
    private static final Stage dialogStage = new Stage();

    public static void displayDialog(){

        Button closeButton = new Button("Close");
        Hyperlink link = new Hyperlink("here");

        VBox content = new VBox(10);
        content.getChildren().addAll(
            new Text(
                "Angular Desktop Version 1.0\n\n" +
                "Created by Wilson Diego Barbosa\n\n" +
                "Wanna see the source code? Access the gitHub repository:"
            ),
            link
        );

        Scene scene = new Scene(content);
        dialogStage.setTitle("About");
        dialogStage.setScene(scene);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.showAndWait();

        closeButton.setOnAction(e->{
            dialogStage.close();
        });

        link.setOnAction(e -> {
            try {
                URI gitHubRepoLink = new URI("https://github.com/Wilson-Barbosa/angular-desktop-manager");
                if(Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(gitHubRepoLink);
                }
            } catch (URISyntaxException | IOException ex) {
                ex.printStackTrace();
            }
        });


    }

}
