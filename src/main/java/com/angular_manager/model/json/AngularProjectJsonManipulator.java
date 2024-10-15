package com.angular_manager.model.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.json.JSONArray;
import org.json.JSONObject;

import com.angular_manager.DTO.ProjectListItemDTO;
import com.angular_manager.enums.ProjectJsonStructure;
import com.angular_manager.util.TerminalPrinter;

/**
 * Class that perfoms operations on the project-list.json file.
 * Extends the super class JsonManipulator
 */
public class AngularProjectJsonManipulator extends JsonManipulator {

    // Constructor
    public AngularProjectJsonManipulator(String jsonDirectory, String fileName) {
        super(jsonDirectory, fileName);
    }


    // Tries to access the file and recovers the array of projects stored there
    public JSONArray getProjectListAsJsonArray(){
        JSONArray projectList = new JSONArray(getFileAsSingleString());
        return projectList;
    }

    // Adds one project to list (single operation)     
    public void addNewProject(ProjectListItemDTO dto){

        // Only writes into if a folder and file both exist
        if(doesFolderExists() && doesFileExists()) {
            JSONArray projectList = getProjectListAsJsonArray();
        
            // Creates the JsonObject and assign the dto's attributes to it
            JSONObject jsonToBeSaved = new JSONObject();
            jsonToBeSaved.put(ProjectJsonStructure.ID.toString(), dto.getId());
            jsonToBeSaved.put(ProjectJsonStructure.PROJECT_NAME.toString(), dto.getProjectName());
            jsonToBeSaved.put(ProjectJsonStructure.PROJECT_PATH.toString(), dto.getProjectPath());
    
            projectList.put(jsonToBeSaved); // adds the project to the list
    
            // now I transform the JSONArray back to a string then transforms it to an array of bytes
            byte[] jsonArrayAsString = projectList.toString().getBytes();
            
            // then I try writting it into a file
            try {
                TerminalPrinter.printMessage("Trying to save new file...");
                Files.write(getAbsolutePath(), jsonArrayAsString, StandardOpenOption.TRUNCATE_EXISTING);
                TerminalPrinter.printMessage("File saved successfully on " + getAbsoluteFilePathAsString());
            } catch (IOException e) {
                TerminalPrinter.printMessage("Could not write into " + getAbsoluteFilePathAsString() + " :");
                e.printStackTrace();
            }
        } else {
            TerminalPrinter.printMessage("Could not write file, because either the folder or file do not exist.");
        }
    }

    // Overrides the createFile() on JsonManipulator by writting a [] inside the file.
    // This is done so that the file will not be empty, otherwise trying to write 
    // the key-value pairs on it will throw an error
    @Override
    public void createFile(){
        super.createFile(); // creates the file

        if(doesFolderExists() && doesFileExists()) {
            byte[] squareBrackets = "[]".getBytes(); // Then writes the [] inside the empty file

            try {
                TerminalPrinter.printMessage("trying to save new file...");
                Files.write(getAbsolutePath(), squareBrackets, StandardOpenOption.TRUNCATE_EXISTING);
                TerminalPrinter.printMessage("file saved successfully on " + getAbsoluteFilePathAsString());
            } catch (IOException e) {
                TerminalPrinter.printMessage("could not write into " + getAbsoluteFilePathAsString() + " :");
                e.printStackTrace();
            }
        }

    }

    // Adds a list of projects to the file
    public void addAllProjects(){

    }

    public void removeProject(){
        
    }
    
}
