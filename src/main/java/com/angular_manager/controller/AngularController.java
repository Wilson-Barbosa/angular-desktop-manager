package com.angular_manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.angular_manager.model.entities.ProjectInfomationJsonModel;
import com.angular_manager.model.enums.FileName;
import com.angular_manager.model.enums.FolderPath;
import com.angular_manager.model.enums.ProjectJsonStructure;
import com.angular_manager.model.json.AngularProjectJsonManipulator;
import com.angular_manager.model.json.ConfigurationJsonManipulator;

public class AngularController {

    private AngularProjectJsonManipulator angularProjectJsonManipulator;
    // private ConfigurationJsonManipulator configurationJsonManipulator;

    public AngularController() {
        this.angularProjectJsonManipulator = new AngularProjectJsonManipulator(
            FolderPath.C_ANGULAR_MANAGER.getPath(), FileName.PROJECT_LIST_JSON
        );

        // this.configurationJsonManipulator = new ConfigurationJsonManipulator(
        //     FolderPath.C_ANGULAR_MANAGER.getPath(), FileName.CONFIGURATION_JSON
        // );
    }

    public List<ProjectInfomationJsonModel> getAllProjectsFromFile() {
        List<ProjectInfomationJsonModel> projectListItemDTOList = new ArrayList<>();

        angularProjectJsonManipulator.getProjectListAsJsonArray().forEach(project -> {
            JSONObject jsonObject = (JSONObject) project;

            projectListItemDTOList.add(new ProjectInfomationJsonModel(
                jsonObject.getInt(ProjectJsonStructure.ID.toString()),
                jsonObject.getString(ProjectJsonStructure.PROJECT_NAME.toString()),
                jsonObject.getString(ProjectJsonStructure.PROJECT_PATH.toString()))
            );
        });

        return projectListItemDTOList;
    }

    


}
