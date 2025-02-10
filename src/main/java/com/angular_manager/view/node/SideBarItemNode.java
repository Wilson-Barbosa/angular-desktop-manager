package com.angular_manager.view.node;

import org.kordamp.ikonli.bootstrapicons.BootstrapIcons;
import org.kordamp.ikonli.javafx.FontIcon;

import com.angular_manager.model.entities.ProjectInfomationJsonModel;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Class that represents an Item inside a left SideBar, it displays the name of the project
 */
public class SideBarItemNode extends HBox {

    private ProjectInfomationJsonModel projectInformation;

    // Constructor
    public SideBarItemNode(ProjectInfomationJsonModel jsonModel) {
        super(5);
        this.projectInformation = jsonModel;

        FontIcon folderIcon = new FontIcon(BootstrapIcons.FOLDER2);
        Text projectName = new Text(jsonModel.getProjectName());

        folderIcon.getStyleClass().add("icon-project");

        super.getStyleClass().addAll("side-bar-item-styling", "clickable");
        super.getChildren().addAll(folderIcon, projectName);

        registerHanlder();
    }

    // Maps the appropriate EventHandler to this Node
    public void registerHanlder(){
        this.setOnMouseClicked(e-> {
            System.out.println("Item " + projectInformation.getId() + " was clicked");
            displayProjectInformationById(projectInformation.getId());
        });
    }

    public void displayProjectInformationById(int id){

        

    }


    public ProjectInfomationJsonModel getProjectInformation() {
        return projectInformation;
    }

    public void setProjectInformation(ProjectInfomationJsonModel jsonModel) {
        this.projectInformation = jsonModel;
    }



}



