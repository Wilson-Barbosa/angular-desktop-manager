package com.angular_manager.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.angular_manager.DTO.ProjectListItemDTO;
import com.angular_manager.enums.ConfigJsonStructure;
import com.angular_manager.enums.FileName;
import com.angular_manager.enums.ProjectJsonStructure;
import com.angular_manager.model.json.AngularProjectJsonManipulator;
import com.angular_manager.model.json.ConfigurationJsonManipulator;

public class AngularController {

    private AngularProjectJsonManipulator angularProjectJsonManipulator;
    private ConfigurationJsonManipulator configurationJsonManipulator;

    public AngularController() {
        this.angularProjectJsonManipulator = new AngularProjectJsonManipulator(
            "C:\\angular-manager", FileName.PROJECT_LIST_JSON
        );

        this.configurationJsonManipulator = new ConfigurationJsonManipulator(
            "C:\\angular-manager", FileName.CONFIGURATION_JSON
        );
    }

    public List<ProjectListItemDTO> getAllProjectsFromFile() {
        List<ProjectListItemDTO> projectListItemDTOList = new ArrayList<>();

        angularProjectJsonManipulator.getProjectListAsJsonArray().forEach(project -> {
            JSONObject jsonObject = (JSONObject) project;

            projectListItemDTOList.add(new ProjectListItemDTO(
                jsonObject.getInt(ProjectJsonStructure.ID.toString()),
                jsonObject.getString(ProjectJsonStructure.PROJECT_NAME.toString()),
                jsonObject.getString(ProjectJsonStructure.PROJECT_PATH.toString()))
            );
        });

        return projectListItemDTOList;
    }



}
