package com.angular_manager.view;

import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Class that represents an Item inside a left SideBar, it displays the name of the project
 */
public class ProjectSideBarItem extends HBox {

    private String projectPath;

    // Constructor
    public ProjectSideBarItem(String angularProjectName, String projectPath) {
        super();
        super.getChildren().add(formatStyle(angularProjectName));
        this.projectPath = projectPath;
    }

    // Creates a formatted Text Node and returns it
    private Text formatStyle(String projectName) {
        Text text = new Text(projectName);
        text.setStyle("-fx-font-size: 16px; -fx-border-color: #000000");
        return text;
    }

    // Setters and Getters
    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

}
