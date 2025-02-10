package com.angular_manager.model.json;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.angular_manager.model.entities.ProjectInfomationJsonModel;
import com.angular_manager.model.enums.FileName;
import com.angular_manager.model.enums.ProjectJsonStructure;
import com.angular_manager.model.util.TerminalPrinter;

/**
 * Class that perfoms operations on the project-list.json file.
 * Extends the super class JsonManipulator.
 */
public class AngularProjectJsonManipulator extends JsonManipulator {

    public AngularProjectJsonManipulator(String jsonDirectory, FileName fileName) {
        super(jsonDirectory, fileName);
    }

    public JSONArray getProjectListAsJsonArray(){

        // it's imperative to treat the case of a null getFileAsSingleString() == null, but how can I do it?
        if(getFileAsSingleString() == null) {
            // maybe I can create and new empty file I an error occurs (if the method returns null that is)
            createFile();
        }
        
        // Then I can run the method again and, this time it will for sure return a valid (empty) string
        return new JSONArray(getFileAsSingleString());
    }

    // Adds one project to list (single operation)     
    public void addNewProject(ProjectInfomationJsonModel projectListItemDTO){

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

    /*
     * Overrides the createFile() on JsonManipulator by writting a [] inside the file.
     * This is done so that the file will not be empty, otherwise trying to write 
     * the key-value pairs on it will throw an error
     */
    @Override
    public void createFile(){
        super.createFile(); // creates the file

        if(doesFolderExists() && !doesFileExists()) {
            byte[] squareBrackets = "[]".getBytes();
            writeIntoFileByTruncanting(squareBrackets, getAbsolutePath());
        }
    }

    public void addAllProjectsToJsonFile(List<ProjectInfomationJsonModel> projectModelList){

        // Only writes into if a folder and file both exist
        if(doesFolderExists() && doesFileExists()) {
            JSONArray jsonArray = getProjectListAsJsonArray();
        
            projectModelList.forEach(project -> {
                
                // Creates the JsonObject and assign the dto's attributes to it
                JSONObject jsonToBeSaved = new JSONObject();
                jsonToBeSaved.put(ProjectJsonStructure.ID.toString(), project.getId());
                jsonToBeSaved.put(ProjectJsonStructure.PROJECT_NAME.toString(), project.getProjectName());
                jsonToBeSaved.put(ProjectJsonStructure.PROJECT_PATH.toString(), project.getProjectPath());
        
                jsonArray.put(jsonToBeSaved); // adds the project to the list
            });
    
            writeIntoFileByTruncanting(jsonArray.toString().getBytes(), getAbsolutePath());
        } else {
            TerminalPrinter.printMessage("Could not write file, because either the folder or file do not exist.");
        }
    }
    
}
