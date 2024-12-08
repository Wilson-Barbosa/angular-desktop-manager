package com.angular_manager.model.entities;

public class ProjectiInformationModel {

    private String name;
    private String location;
    private String version;
    private String angularCliVersion;

    public ProjectiInformationModel() {
        
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public String getAngularCliVersion() {
        return angularCliVersion;
    }


    public void setAngularCliVersion(String angularCliVersion) {
        this.angularCliVersion = angularCliVersion;
    }

}
