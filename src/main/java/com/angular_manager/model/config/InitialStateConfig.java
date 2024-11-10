package com.angular_manager.model.config;

import com.angular_manager.model.AngularProjectSearcher;
import com.angular_manager.model.enums.ConfigJsonStructure;
import com.angular_manager.model.enums.FileName;
import com.angular_manager.model.enums.FolderPath;
import com.angular_manager.model.json.AngularProjectJsonManipulator;
import com.angular_manager.model.json.ConfigurationJsonManipulator;

/**
 * When the application runs this class' methods will be called
 */
public class InitialStateConfig {

    // TODO This is temporary, soon I will substitue these hardcoded values
    private static final ConfigurationJsonManipulator configJson = new ConfigurationJsonManipulator(
        FolderPath.DOCUMENTS_ANGULAR_MANAGER.getPath(), FileName.CONFIGURATION_JSON
    );

    private static final AngularProjectJsonManipulator angularJson = new AngularProjectJsonManipulator(
        FolderPath.DOCUMENTS_ANGULAR_MANAGER.getPath(), FileName.PROJECT_LIST_JSON
    );

    // Execute all routines here
    public static void setApplicationInitialState(){
        setConfigJsonState();
        setAngularProjectJsonState();
        // setProjectSearchInitialState();
    }


    // Method that creates the folder a file to hold the angular project list
    // It will be called on every application run
    private static void setAngularProjectJsonState(){
        if(!angularJson.doesFolderExists()) {
            angularJson.createFolder();
        }

        if(!angularJson.doesFileExists()) {
            angularJson.createFile();
        }
    }

    // Method that creates the folder a file to hold the angular project list
    // It will be called on every application run
    private static void setConfigJsonState(){
        if(!configJson.doesFolderExists()) {
            configJson.createFolder();
        }

        if(!configJson.doesFileExists()) {
            configJson.createFile();
        }
    }

    private static void setProjectSearchInitialState(){
        if(canSeachForProjectsOnAppInit()) {
            AngularProjectSearcher.searchForAngularProject();
        }
    }

    private static boolean canSeachForProjectsOnAppInit(){
        return configJson.getBooleanValueFromKey(ConfigJsonStructure.SEARCH_FOR_PROJECTS_ON_APP_INIT);
    }

}
