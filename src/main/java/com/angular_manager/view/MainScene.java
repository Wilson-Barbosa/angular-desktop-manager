package com.angular_manager.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

// This class creates the only scene used on the project
public abstract class MainScene {
    /*
     * The main scene will be composed of two parts:
     * 1. A letf, vertical SideBar
     * 2. A right screen where a user can actively interact with
     */
    public static Scene createMainScene() {

        // Create TopNavBar
        TopNavBar topNavBar = new TopNavBar();

        // Create the SideBar
        ProjectListSideBar sideBar = new ProjectListSideBar();
        sideBar.addSingleItem(new ProjectSideBarItem("E-commerce projet", null));
        sideBar.addSingleItem(new ProjectSideBarItem("Wether app", null));
        sideBar.addSingleItem(new ProjectSideBarItem("Angular CRUD", null));

        // Create the RightScreen
        GridPane rightScreen = new GridPane();

        // Creates a simple footer
        Footer footer = new Footer();

        // Couples everything together on a BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(sideBar);
        borderPane.setRight(rightScreen);
        borderPane.setTop(topNavBar);
        borderPane.setBottom(footer);

        // Adds the BorderPane to the scene
        Scene scene = new Scene(borderPane, 900, 600);
        scene.getStylesheets().add("styles.css"); // adds the .css to the project

        return scene;
    }

}
