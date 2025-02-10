package com.angular_manager.view.node;

import java.util.List;

import org.kordamp.ikonli.bootstrapicons.BootstrapIcons;
import org.kordamp.ikonli.javafx.FontIcon;

import com.angular_manager.model.entities.ProjectInfomationJsonModel;
import com.angular_manager.model.search.AngularProjectSearcher;

import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Class that represents a left SideBar, where the project's names are displayed
 */
public class SideBarNode extends ScrollPane {

    private final VBox sideBar = new VBox(7);
    
    // Create the SideBar as a VBox inside a ScrollPane
    public SideBarNode(){
        super(); // creates the ScrollPane
        super.getStyleClass().addAll("side-bar-styling"); // adds css class
        super.setContent(sideBar); // puts the vbox as the content of scrollPane

        // Enable scrolling
        this.setFitToWidth(true); // Ensure that items stretch to fit the width
        this.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED); // Vertical scrollbar appears when needed
        
        createIconBar();
            
        reloadProjectList();
    }


    private void createIconBar(){
        HBox iconBar = new HBox(6);

        FontIcon reloadIcon = new FontIcon(BootstrapIcons.ARROW_COUNTERCLOCKWISE);
        reloadIcon.getStyleClass().addAll("clickable");

        FontIcon searchIcon = new FontIcon(BootstrapIcons.SEARCH);
        searchIcon.getStyleClass().addAll("clickable");

        FontIcon addNewIcon = new FontIcon(BootstrapIcons.FILE_EARMARK_PLUS);
        addNewIcon.getStyleClass().addAll("clickable");

        iconBar.getChildren().addAll(addNewIcon, searchIcon, reloadIcon);
        iconBar.setAlignment(Pos.BASELINE_RIGHT);
        iconBar.getStyleClass().add("icon-bar");
        
        this.sideBar.getChildren().addAll(iconBar);

        // Registers the eventHandlers
        reloadIcon.setOnMouseClicked(e -> {
            reloadProjectList();
        });

        searchIcon.setOnMouseClicked(e -> {
            // TODO add the serching operation here
        });
    }

    private void addProjectToSideBar(ProjectInfomationJsonModel model){
        SideBarItemNode item = new SideBarItemNode(model);
        this.sideBar.getChildren().addAll(item);
    }

    private void reloadProjectList(){
        clearProjectList();

        // After everything is cleared then the nodes can be added again
    }

    public void clearProjectList(){
        // clears all the nodes, expect the iconBar
        this.sideBar.getChildren().remove(1, this.sideBar.getChildren().size());
    }
    
}
