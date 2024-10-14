package com.angular_manager.model.json;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.angular_manager.util.TerminalPrinter;

/**
 * Class that performs operations on the JSON files
 */
public class JsonManipulator {

    // specifies the location where the json is located and the name of the files inside of it
    private final String directory; // this is an absolute path
    private final String fileName;

    // Constructor
    public JsonManipulator(String directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
    }

    // Creates a directory on a given path 
    public void createDirectory() {
        try {

            if (doesFolderExists()) {
                TerminalPrinter.printMessage("folder " + directory + " already exists");
            } else {
                TerminalPrinter.printMessage("folder " + directory + " does not exist, trying to create it...");
                Files.createDirectory(Paths.get(directory)); // creates the actual directory
                TerminalPrinter.printMessage("folder " + directory + " created successfully");
            }

        } catch (Exception e) {
            TerminalPrinter.printMessage("an error has occureed while creating " + directory + ": ");
            e.printStackTrace();
        }
    }

    // Creates a file inside the directory (if it exists that is)
    public void createFile() {
        try {
            if(!doesFolderExists()){
                TerminalPrinter.printMessage("folder " + directory + " does not exist. No file was created");
            } else
            if (doesFileExists()) {
                TerminalPrinter.printMessage("file " + fileName + " already exists on path " + directory);
            } else {
                TerminalPrinter.printMessage("file " + fileName + " does not exist. Trying to create it...");
                Path dir = Paths.get(directory); // Directory path
                Path file = dir.resolve(fileName); // File path inside the directory
                Files.createFile(file);
                TerminalPrinter.printMessage("file " + fileName + " created successfully");
            }

        } catch (Exception e) {
            TerminalPrinter.printMessage("an error has occureed while creating " + directory + ": ");
        }
    }

    // Returns true if the folder exists from that path
    public boolean doesFolderExists() {
        Path dir = Paths.get(directory);
        return Files.exists(dir) && Files.isDirectory(dir);
    }

    // Returns true if the file existis on a given directory
    public boolean doesFileExists() {
        Path path = Paths.get(directory + "\\" + fileName);
        return Files.exists(path);
    }

    // checks if the file has a .json extension
    public boolean isTheFileJson(){
        return fileName.endsWith(".json");
    }

    public String getAbsoluteFilePath(){
        return directory + "/" + fileName;
    }


}
