package com.angular_manager.model.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.json.JSONArray;
import org.json.JSONObject;

import com.angular_manager.DTO.BasicProjectInfoDTO;

/**
 * Class that perfoms operations on the project-list.json file. Extends the super class JsonManipulator
 */
public class AngularProjectJsonManipulator extends JsonManipulator {

    // Constructor
    public AngularProjectJsonManipulator(String jsonDirectory, String fileName) {
        super(jsonDirectory, fileName);
    }

    
    public void addNewProject(BasicProjectInfoDTO basicProjectInfoDTO){

        BasicProjectInfoDTO dto = new BasicProjectInfoDTO(1, "angular test", "fileName");
        
        JSONObject jo = new JSONObject();
        jo.put("id", dto.getId());
        jo.put("projectName", dto.getProjectName());
        jo.put("projectPath", dto.getProjectPath());
    

        try {
            Files.write(Paths.get("C:\\angular-manager\\project-list.json"), jo.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
