package com.angular_manager.view.node;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TopNavBar extends HBox {

    // Constructor
    public TopNavBar(){
        super(10); // add some spacing to the box

        // TODO I need to change this later
        super.getChildren().addAll(new Text("Preferences"), new Text("Help"), new Text("About"));
        super.getStyleClass().add("top-nav-bar-styling");
    }

}
