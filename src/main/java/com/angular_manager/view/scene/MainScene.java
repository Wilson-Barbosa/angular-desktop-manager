package com.angular_manager.view.scene;

import com.angular_manager.view.node.Footer;
import com.angular_manager.view.node.MainContentPane;
import com.angular_manager.view.node.ProjectListSideBar;
import com.angular_manager.view.node.TopNavBar;

import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;

public abstract class MainScene {
    /*
     * The main scene will be composed of two parts:
     * 1. A left, vertical SideBar
     * 2. A right screen where a user can actively interact with
     */
    public static Scene createMainScene() {

        // Create the SideBar
        ProjectListSideBar sideBar = new ProjectListSideBar();

        // Create the RightScreen
        MainContentPane mainContent = new MainContentPane();

        // Creates a SplitPanel to hold the SideBar on the left and mainContent on the right
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(sideBar, mainContent);
        splitPane.setDividerPosition(0, 0.15); // gives a percentagem of the screen for the sideBar

        // Couples everything together on a BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new TopNavBar()); // Creates a simple navBar
        borderPane.setCenter(splitPane);
        borderPane.setBottom(new Footer()); // Creates a simple footer

        // Adds the BorderPane to the scene
        Scene scene = new Scene(borderPane, 1000, 650);
        scene.getStylesheets().add("styles.css"); // adds the .css to the project

        return scene;
    }

}
