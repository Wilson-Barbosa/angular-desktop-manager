package com.angular_manager.model.json;

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
        // TODO it's imperative to treat the case of a null getFileAsSingleString() == null, but how can I do it?
        return new JSONArray(getFileAsSingleString());
    }

    // Adds one project to list (single operation)     
    public void addNewProject(ProjectListItemDTO projectListItemDTO){

        // Only writes into if a folder and file both exist
        if(doesFolderExists() && doesFileExists()) {
            JSONArray projectList = getProjectListAsJsonArray();
        
            // Creates the JsonObject and assign the dto's attributes to it
            JSONObject jsonToBeSaved = new JSONObject();
            jsonToBeSaved.put(ProjectJsonStructure.ID.toString(), projectListItemDTO.getId());
            jsonToBeSaved.put(ProjectJsonStructure.PROJECT_NAME.toString(), projectListItemDTO.getProjectName());
            jsonToBeSaved.put(ProjectJsonStructure.PROJECT_PATH.toString(), projectListItemDTO.getProjectPath());
    
            projectList.put(jsonToBeSaved); // adds the project to the list
    
            writeIntoFileByTruncanting(projectList.toString().getBytes(), getAbsolutePath());
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
            byte[] squareBrackets = "[]".getBytes();
            writeIntoFileByTruncanting(squareBrackets, getAbsolutePath());
        }
    }

    public void addAllProjects(){

    }

    public void removeProject(){
        
    }
    
}
