package com.angular_manager.view.node;

import com.angular_manager.DTO.ProjectListItemDTO;
import com.angular_manager.model.json.AngularProjectJsonManipulator;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class MainContentPane extends GridPane {
    
    public MainContentPane(){
        super();

        AngularProjectJsonManipulator json = new AngularProjectJsonManipulator("C:\\angular-manager", "project-list.json");

        ProjectListItemDTO project = new ProjectListItemDTO(1, "test name", "test path");

        Button createFolder = new Button("Create folder");
        Button createFile = new Button("Create file");
        Button addProject = new Button("Add Project");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(createFolder, createFile, addProject);
        super.getChildren().add(hBox);

        // Events
        createFile.setOnAction(e -> {
            json.createFile();            
        });
        
        createFolder.setOnAction(e -> {
            json.createDirectory();
        });

        addProject.setOnAction(e -> {
            json.addNewProject(project);
        });
    }
    
}
