package com.angular_manager.view.node;

import org.kordamp.ikonli.bootstrapicons.BootstrapIcons;
import org.kordamp.ikonli.javafx.FontIcon;

import com.angular_manager.controller.AngularController;
import com.angular_manager.model.DTO.ProjectListItemDTO;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Class that represents a left SideBar, where the project's names are displayed
 */
public class ProjectListSideBar extends ScrollPane {

    private final VBox sideBar = new VBox(7);
    private final AngularController angularController = new AngularController();
    
    // Create the SideBar as a VBox inside a ScrollPane
    public ProjectListSideBar(){
        super(); // creates the ScrollPane
        super.getStyleClass().addAll("side-bar-styling"); // adds css class
        super.setContent(sideBar); // puts the vbox as the content of scrollPane

        createIconBar();
            
        // Enable scrolling
        this.setFitToWidth(true); // Ensure that items stretch to fit the width
        this.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scrollbar appears when needed

    }

    // Adds an HBox with some options

    private void createIconBar(){
        HBox iconBar = new HBox(3);

        FontIcon reloadIcon = new FontIcon(BootstrapIcons.ARROW_COUNTERCLOCKWISE);
        reloadIcon.getStyleClass().addAll("clickable");

        iconBar.getChildren().addAll(reloadIcon);
        iconBar.setAlignment(Pos.BASELINE_RIGHT);
        iconBar.getStyleClass().add("icon-bar");
        
        this.sideBar.getChildren().addAll(iconBar);

        // Registers the eventHandlers
        reloadIcon.setOnMouseClicked(e -> {
            reloadProjectList();
        });
    }

    private void addSingleProjectToSideBar(ProjectListItemDTO projectListItemDTO){
        ProjectSideBarItem item = new ProjectSideBarItem(projectListItemDTO);
        this.sideBar.getChildren().addAll(item);
    }

    private void reloadProjectList(){
        clearProjectList();

        // After everything is cleared then the nodes can be added again
        angularController.getAllProjectsFromFile().forEach(project ->{
            addSingleProjectToSideBar(project);
        });
    }

    public void clearProjectList(){
        // clears all the nodes, expect the iconBar
        this.sideBar.getChildren().remove(1, this.sideBar.getChildren().size());
    }

    private void getProjectsFromJsonStorage(){
        
    }
    
}
