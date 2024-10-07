package com.angular_manager.view;

import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TopNavBar extends HBox {

    // Constructor
    public TopNavBar(){
        super();
        super.setBorder(Border.stroke(Color.BLACK));
        super.getChildren().addAll(new Text("Preferences"), new Text("Help"), new Text("About"));
    }



}
