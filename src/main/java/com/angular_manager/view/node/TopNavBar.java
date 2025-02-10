package com.angular_manager.view.node;

import com.angular_manager.view.stage.AboutDialog;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TopNavBar extends HBox {

    // Constructor
    public TopNavBar(){
        super(10); // add some spacing to the box

        Label preferences = new Label("Preferences");
        Label help = new Label("Help");
        AboutLabel about = new AboutLabel("About");

        super.getChildren().addAll(preferences, help, about);

        // Adds a css class to each labe
        this.getChildren().forEach(child -> {
            child.getStyleClass().addAll("clickable", "navbar-label");
            
        });

        super.getStyleClass().addAll("top-nav-bar-styling"); // styling fot the navbar container
    }

}

class AboutLabel extends Label {
    public AboutLabel(String label){
        super(label);
        this.setOnMouseClicked(e -> AboutDialog.displayDialog());
    }
}
