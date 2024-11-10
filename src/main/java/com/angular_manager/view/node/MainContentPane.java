package com.angular_manager.view.node;

import javafx.scene.layout.GridPane;


public class MainContentPane extends GridPane {
    
    public MainContentPane(){
        super();

        // AngularProjectJsonManipulator json = new AngularProjectJsonManipulator(
        //     "C:\\angular-manager", "project-list.json"
        // );

        // Button createFolder = new Button("Create folder");
        // Button createFile = new Button("Create file");
        // Button addProject = new Button("Add Project");
        // Button readJson = new Button("Read Json");

        // HBox hBox = new HBox();
        // hBox.getChildren().addAll(createFolder, createFile, addProject, readJson);
        // super.getChildren().add(hBox);

        // // Events
        // createFile.setOnAction(e -> {
        //     json.createFile();            
        // });
        
        // createFolder.setOnAction(e -> {
        //     json.createFolder();
        // });

        // readJson.setOnAction(e -> {
        //     json.getAllProjectsFromFile();
        // });

        // addProject.setOnAction(e -> {

        //     List<ProjectListItemDTO> projects = new ArrayList<>();
        //     projects.add(new ProjectListItemDTO(1, "Angular e-commerce", "test path"));
        //     projects.add(new ProjectListItemDTO(2, "Angular CRUD", "test path"));
        //     projects.add(new ProjectListItemDTO(3, "Project car", "test path"));
        //     projects.add(new ProjectListItemDTO(4, "todo app list", "test path"));

        //     json.addProjectsToJsonFile(projects);
        // });
    }
    
}
