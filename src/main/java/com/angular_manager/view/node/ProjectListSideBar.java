package com.angular_manager.view.node;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Class that represents a left SideBar, where the project's names are displayed
 */
public class ProjectListSideBar extends ScrollPane {

    private VBox vBox;
    
    // Create the SideBar as a VBox inside a ScrollPane
    public ProjectListSideBar(){
        super(); // creates the ScrollPane

        super.getStyleClass().add("side-bar-styling"); // adds css class

        this.vBox = new VBox(7); // creates the vBox with some spacing

        super.setContent(vBox); // puts the vbox as the content of scrollPane
            
        // Enable scrolling
        this.setFitToWidth(true); // Ensure that items stretch to fit the width
        this.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scrollbar appears when needed

        addHeaderToBar();
    }

    // Method that adds a new Item inside the SideBar
    public void addSingleItem(ProjectSideBarItem item){
        getvBox().getChildren().add(item);
    }

    // Adds an HBox with some options
    private void addHeaderToBar(){

        HBox optionsMenu = new HBox();
        optionsMenu.getStyleClass().add("side-bar-option-styling"); // adds css class

        Text header = new Text("Project List");
        header.getStyleClass().add("header");
        
        this.vBox.getChildren().addAll(optionsMenu, header);
    }

    // Setters and Getters
    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    

}
