package com.angular_manager.model.json;

import org.json.JSONObject;

import com.angular_manager.enums.ConfigJsonStructure;
import com.angular_manager.enums.FileName;

/*
 * Controls the configuration json, these are configurations used by the application 
 */
public class ConfigurationJsonManipulator extends JsonManipulator{

    public ConfigurationJsonManipulator(String directory, FileName fileName) {
        super(directory, fileName);
    }

    @Override
    public void createFile(){
        super.createFile();

        JSONObject jsonObject = new JSONObject();
        // sets the default value upon file creation
        jsonObject.put(ConfigJsonStructure.SEARCH_FOR_PROJECTS_ON_APP_INIT.toString(), true);

        super.writeIntoFileByTruncanting(jsonObject.toString().getBytes(), getAbsolutePath());
    }

    public boolean getBooleanValueFromKey(ConfigJsonStructure key){
        JSONObject json =  new JSONObject(super.getFileAsSingleString());
        return json.getBoolean(key.toString());
    }


    
}
