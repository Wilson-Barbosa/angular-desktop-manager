package com.angular_manager.model.entities;

/**
 * Models a single entry inside the ProjectList JSON file
 */
public class ProjectInfomationJsonModel {

    private int id;
    private String projectName;
    private String projectPath;

    // Empty constructor
    public ProjectInfomationJsonModel(){

    }

    // Full-Args Constructor
    public ProjectInfomationJsonModel(int id, String projectName, String projectPath) {
        this.id = id;
        this.projectName = projectName;
        this.projectPath = projectPath;
    }

    // Setters and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    @Override
    public String toString() {
        return "ProjectListItemDTO [id=" + id + ", projectName=" + projectName + ", projectPath=" + projectPath + "]";
    }

}
