package com.angular_manager.view.node;


import com.angular_manager.model.exception.ThreadRunningException;
import com.angular_manager.model.search.AngularProjectSearcher;
import com.angular_manager.model.util.TerminalPrinter;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class WelcomeNode extends VBox {
    
    public WelcomeNode(){
        super();
        createLayout();
    }

    private void createLayout(){

        Label welcomeTitleLabel = new Label("Welcome to Angular Desktop Manager");
        welcomeTitleLabel.getStyleClass().add("welcome-title");

        Label welcomeTextLabel = new Label("\nSearch for local Angular Projects!\n\n" +
                                           "Check information, such as dependencies, version and more!\n\n" +
                                           "Perform Angular CLI operations through this interface (in construction)\n\n" +
                                           "Let the application search for projects or add them manually (in construction)\n\n" +
                                           "More functionalities will be added in the near future!"
        );
        welcomeTextLabel.getStyleClass().add("welcome-text");

        Separator separator = new Separator();
        separator.setPadding(new Insets(20, 0, 10, 0));

        Label optionsLabel = new Label("Options");
        optionsLabel.getStyleClass().add("welcome-title");

        Label optionstextLabel = new Label("Click on the button below to search for your local projects:");
        optionstextLabel.getStyleClass().add("welcome-text");
        optionstextLabel.setPadding(new Insets(10, 0, 10, 0));
        
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            try {
                AngularProjectSearcher searcher = new AngularProjectSearcher();
                searcher.run();
            } catch (ThreadRunningException exception) {
                TerminalPrinter.printMessage(exception.getMessage());
            }

        });
        
        this.getChildren().addAll(
            welcomeTitleLabel,
            welcomeTextLabel,
            separator,
            optionsLabel,
            optionstextLabel,
            searchButton
        );

    }



}
