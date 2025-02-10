package com.angular_manager.view.node;

import com.angular_manager.model.entities.ProjectiInformationModel;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;


public class MainContentPane extends GridPane {
    
    public MainContentPane(){
        super();
        super.getStyleClass().add("main-content"); 
        
        // by default, the welcome node will be displayed once the MainContentPane is drawn
        addNodeToMainContentPane(new WelcomeNode());
        
        // ProjectiInformationModel model = new ProjectiInformationModel();
        // model.setName("My Angular Project");
        // model.setLocation("Desktop:files/angular/projects");
        // model.setVersion("1.2");
        // model.setAngularCliVersion("17.2");

        // ProjectInformationNode node = new ProjectInformationNode(model);
        // addNodeToMainContentPane(node);
    }

    private void clearMainContent(){
        this.getChildren().clear();
    }

    public void addNodeToMainContentPane(Node node){
        clearMainContent();
        this.getChildren().add(node);
    }

}
