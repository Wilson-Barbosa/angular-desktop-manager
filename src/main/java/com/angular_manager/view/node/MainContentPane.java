package com.angular_manager.view.node;

import com.angular_manager.model.json.AngularProjectJsonManipulator;
import com.angular_manager.model.json.JsonManipulator;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class MainContentPane extends GridPane {
    
    public MainContentPane(){
        super();

        Button button = new Button("Add keys");
        super.getChildren().add(button);
        
        button.setOnAction(e -> {

            // Lets add an intance of the json manipulator and iteract with it
            AngularProjectJsonManipulator json = new AngularProjectJsonManipulator("C:\\angular-manager", "project-list.json");
            json.createJSONFileOnFolder();

            json.addNewProject(null);

        });
    }
    
}
