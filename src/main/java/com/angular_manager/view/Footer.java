package com.angular_manager.view;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Footer extends VBox {

    public Footer(){
        super();
        Text text = new Text("Created by Wilson Diego Barbosa");
        super.getChildren().add(text);
        super.getStyleClass().add("footer-styling");
    }


}
