package com.angular_manager.view.node;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Class that represents an Item inside a left SideBar, it displays the name of the project
 */
public class ProjectSideBarItem extends HBox {

    private String projectPath;

    // Constructor
    public ProjectSideBarItem(String angularProjectName, String projectPath) {
        super();
        super.getChildren().add(new Text(angularProjectName));
        super.getStyleClass().add("side-bar-item-styling");
        this.projectPath = projectPath;

        registerHanlder();
    }

    // Maps the appropriate EventHandler to this Node
    public void registerHanlder(){
        ItemClickEventHandler handler = new ItemClickEventHandler();
        super.setOnMouseClicked(handler);
    }


    // Setters and Getters
    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }



    // Class that handles the event fired when a user clicks on a item in the list
    class ItemClickEventHandler implements EventHandler<MouseEvent> {

    // On every mouse click the method below will be called 
    @Override
    public void handle(MouseEvent e) {
        System.out.println("Item was clicked");
        
    }
}

}



