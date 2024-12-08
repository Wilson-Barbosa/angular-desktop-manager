package com.angular_manager.view.stage;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AboutDialog extends Stage {
    
    public static void displayDialog(){

        Stage dialogStage = new Stage();
        Hyperlink link = new Hyperlink("here");
        VBox content = new VBox(10);
        content.getChildren().addAll(
            new Text(
                "Angular Desktop Version 1.0\n\n" +
                "Created by Wilson Diego Barbosa\n\n" +
                "Wanna see the source code? Access the gitHub repository:\n" +
                "https://github.com/Wilson-Barbosa/angular-desktop-manager"
            ),
            link
        );
        content.setPadding(new Insets(20));

        Scene scene = new Scene(content);
        dialogStage.setTitle("About");
        dialogStage.setScene(scene);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.showAndWait();

        // link.setOnAction(e -> {
        //     try {
        //         URI gitHubRepoLink = new URI("https://github.com/Wilson-Barbosa/angular-desktop-manager");
        //         if(Desktop.isDesktopSupported()) {
        //             Desktop.getDesktop().browse(gitHubRepoLink);
        //         }
        //     } catch (URISyntaxException | IOException ex) {
        //         ex.printStackTrace();
        //     }
        // });


    }

}
