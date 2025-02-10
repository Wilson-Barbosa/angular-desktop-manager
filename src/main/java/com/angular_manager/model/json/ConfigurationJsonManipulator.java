package com.angular_manager.model.json;

import org.json.JSONObject;

import com.angular_manager.model.enums.ConfigJsonStructure;
import com.angular_manager.model.enums.FileName;

/** Controls the configuration json, these are configurations used by the application */
public class ConfigurationJsonManipulator extends JsonManipulator{

    public ConfigurationJsonManipulator(String directory, FileName fileName) {
        super(directory, fileName);
    }

    /**
     * Overrides the createFile() by writting in key-value pairs for configurations 
     */
    @Override
    public void createFile(){
        super.createFile();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(ConfigJsonStructure.SEARCH_FOR_PROJECTS_ON_APP_INIT.toString(), false);

        super.writeIntoFileByTruncanting(jsonObject.toString().getBytes(), getAbsolutePath());
    }

    public boolean getBooleanValueFromKey(ConfigJsonStructure key){
        JSONObject json =  new JSONObject(super.getFileAsSingleString());
        return json.getBoolean(key.toString());
    }


    
}
