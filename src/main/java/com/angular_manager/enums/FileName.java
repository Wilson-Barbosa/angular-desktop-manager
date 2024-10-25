package com.angular_manager.enums;

public enum FileName {

    CONFIGURATION_JSON("configuration.json"),
    PROJECT_LIST_JSON("project_list.json"),
    ANGULAR_JSON("angular.json"),
    PACKAGE_JSON("package.json");

    private final String name;

    FileName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
