package com.angular_manager.view.node;

import com.angular_manager.model.json.AngularProjectJsonManipulator;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class MainContentPane extends GridPane {
    
    public MainContentPane(){
        super();

        AngularProjectJsonManipulator json = new AngularProjectJsonManipulator("C:\\angular-manager", "project-list.json");

        Button createFolder = new Button("Create folder");
        Button createFile = new Button("Create file");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(createFolder, createFile);

        super.getChildren().add(hBox);

        createFile.setOnAction(e -> {
            json.createFile();            
        });
        
        createFolder.setOnAction(e -> {
            json.createDirectory();
        });
    }
    
}
