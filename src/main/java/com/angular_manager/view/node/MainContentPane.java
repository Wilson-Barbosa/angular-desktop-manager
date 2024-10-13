package com.angular_manager.view.node;

import com.angular_manager.model.JsonManipulator;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MainContentPane extends GridPane {
    
    public MainContentPane(){
        super();

        Button button = new Button("Add");
        super.getChildren().add(button);
        
        button.setOnAction(e -> {

            // Lets add an intance of the json manipulator and iteract with it
            JsonManipulator jsonManipulator1 = new JsonManipulator("C:\\angular-manager", "project-list.json");
            jsonManipulator1.createJSONFileOnFolder();


            // Adiciona um nova key no json

        });
    }
    
}
