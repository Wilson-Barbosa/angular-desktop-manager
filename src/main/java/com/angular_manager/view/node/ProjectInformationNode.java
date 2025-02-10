package com.angular_manager.view.node;

import com.angular_manager.model.entities.ProjectiInformationModel;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Class that represents the information 
 */
public class ProjectInformationNode extends VBox {

    private Label titleLabel;
    private Label projectLocationLabel;
    private Label versionLabel;
    private Label angularCliLabel;

    public ProjectInformationNode(ProjectiInformationModel model) {
        super(5);
        this.titleLabel = new Label(model.getName());
        this.projectLocationLabel = new Label(model.getLocation());
        this.versionLabel = new Label(model.getVersion());
        this.angularCliLabel = new Label(model.getAngularCliVersion());

        createLayout();
    }

    private void createLayout() {
        this.getStyleClass().add("project-content");
        createTitle();
        createBody();
    }

    private void createTitle(){
        Label nodeTitle = new Label("Project Information");
        nodeTitle.getStyleClass().add("welcome-title");
        this.getChildren().addAll(nodeTitle);
    }

    private void createBody(){

        Label name = new Label("Name:  ");
        Label location = new Label("Location:  ");
        Label version = new Label("Version:  ");
        Label cliVersion = new Label("Angular Cli Version:  ");

        name.getStyleClass().add("project-information-label");
        location.getStyleClass().add("project-information-label");
        version.getStyleClass().add("project-information-label");
        cliVersion.getStyleClass().add("project-information-label");

        HBox hBox1 = new HBox(name, titleLabel);
        HBox hBox2 = new HBox(location, projectLocationLabel);
        HBox hBox3 = new HBox(version, versionLabel);
        HBox hBox4 = new HBox(cliVersion, angularCliLabel);

        this.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);
    }

    private void createButtons(){

    }


    // Setters and Getters
    public Label getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(Label titleLabel) {
        this.titleLabel = titleLabel;
    }

    public Label getProjectLocationLabel() {
        return projectLocationLabel;
    }

    public void setProjectLocationLabel(Label projectLocationLabel) {
        this.projectLocationLabel = projectLocationLabel;
    }

    public Label getVersionLabel() {
        return versionLabel;
    }

    public void setVersionLabel(Label versionLabel) {
        this.versionLabel = versionLabel;
    }

    public Label getAngularCliLabel() {
        return angularCliLabel;
    }

    public void setAngularCliLabel(Label angularCliLabel) {
        this.angularCliLabel = angularCliLabel;
    }

    

}
