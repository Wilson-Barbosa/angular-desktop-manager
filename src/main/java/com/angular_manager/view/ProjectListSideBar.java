package com.angular_manager.view;

import javafx.scene.layout.VBox;

/**
 * Class that represents a left SideBar, where the project's names are displayed
 */
public class ProjectListSideBar extends VBox {
    
    // Create SideBar as a VBox
    public ProjectListSideBar(){
        super(7); // creates an empty box with some spacing between the items
        super.getStyleClass().add("side-bar-styling");
    }

    // Method that adds a new Item inside the SideBar
    public void addSingleItem(ProjectSideBarItem item){
        super.getChildren().add(item);
    }


}
