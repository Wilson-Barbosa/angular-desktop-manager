package com.angular_manager.model;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.angular_manager.DTO.BasicProjectInfoDTO;
import com.angular_manager.util.TerminalPrinter;

/**
 * Class that performs operations on the JSON file where the projects are store
 * offers various methods for creating and altering the file or its folder
 */
public class JsonManipulator {

    // specifies the location where the json is located and the name of the files inside of it
    private final String jsonDirectory;
    private final String fileName;

    public JsonManipulator(String jsonDirectory, String fileName){
        this.jsonDirectory = jsonDirectory;
        this.fileName = fileName;
    }

    // creates a new JSON file to store the list of projects
    public void createJSONFile() {

        // first I check if the directory exists, if not then create it
        Path folder = Paths.get(jsonDirectory);
        if (Files.exists(folder)) {
            TerminalPrinter.printMessage("folder " + jsonDirectory + " already exists.");
        } else {
            TerminalPrinter.printMessage("folder " + jsonDirectory + " does not exists, creating a new one...");

            // Tries to create the folder
            try {
                Files.createDirectory(folder);
                TerminalPrinter.printMessage("folder " + jsonDirectory + " was created successfully.");
            } catch (Exception e) {
                TerminalPrinter.printMessage("an unexpected error has occurred, check it out: ");
                e.printStackTrace();
            }

        }

        // Now I need to create the .json inside the directory
        try {
            File file = new File(jsonDirectory, fileName); // object containing the path and file names

            // obs: createNewFile() returns a boolean
            if (file.createNewFile()) {
                TerminalPrinter.printMessage("file " + fileName + " was created on path " + jsonDirectory);
            } else {
                TerminalPrinter.printMessage("file " + fileName + " already exists on path " + jsonDirectory);
            }

        } catch (Exception e) {
            TerminalPrinter.printMessage("an unexpected error has occurred, check it out: ");
            e.printStackTrace();
        }

    }

    // recovers All projects from the .json file
    public List<BasicProjectInfoDTO> getAllProjects() {

        List<BasicProjectInfoDTO> projectList = new ArrayList<>();
        // here I need to call the method that will read the .json file and recover the info

        return projectList;
    }

    public void addNewProject() {

    }


}