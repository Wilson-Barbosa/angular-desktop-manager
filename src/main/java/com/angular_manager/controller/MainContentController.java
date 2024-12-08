package com.angular_manager.controller;

import com.angular_manager.model.entities.ProjectiInformationModel;
import com.angular_manager.view.node.MainContentPane;
import com.angular_manager.view.node.ProjectInformationNode;

public class MainContentController {
    
    // Reference for the MainPane
    MainContentPane mainContentPane = new MainContentPane();

    // method that takes a project's info and sends calls the method to
    public void displayProjectInformation(ProjectiInformationModel model){
        ProjectInformationNode projectInformationNode = new ProjectInformationNode(model);
        mainContentPane.addNodeToMainContentPane(projectInformationNode);
    }

}
