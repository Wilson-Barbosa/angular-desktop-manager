package com.angular_manager.model.enums;

public enum FolderPath {

    DOCUMENTS_ANGULAR_MANAGER("Documents\\angular-manager"),
    C_ANGULAR_MANAGER("C:\\angular-manager");

    FolderPath(String path) {
        this.path = path;
    }

    private final String path;

    public String getPath() {
        return this.path;
    }

}
