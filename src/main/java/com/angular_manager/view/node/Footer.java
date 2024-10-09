package com.angular_manager.view.node;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Footer extends VBox {

    public Footer(){
        super();
        Text text = new Text("Created by Wilson Diego Barbosa");
        // text.setFill(Color.WHITE);
        super.getChildren().add(text);
        super.getStyleClass().add("footer-styling");
    }


}
