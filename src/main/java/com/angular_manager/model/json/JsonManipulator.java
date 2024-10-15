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
    private final String directory; // directory is an absolute path
    private final String fileName; // fileName must contain the .json extension 

    // Constructor
    public JsonManipulator(String directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
    }

    // Creates a directory on a given path 
    public void createDirectory() {
        try {
            if (doesFolderExists()) {
                TerminalPrinter.printMessage("Folder " + directory + " already exists");
            } else {
                TerminalPrinter.printMessage("Folder " + directory + " does not exist, trying to create it...");
                Files.createDirectory(Paths.get(directory)); // creates the actual directory
                TerminalPrinter.printMessage("Folder " + directory + " created successfully");
            }
        } catch (Exception e) {
            TerminalPrinter.printMessage("An error has occureed while creating " + directory + ": ");
            e.printStackTrace();
        }
    }

    // Creates a file inside the directory (if it exists that is)
    public void createFile() {
        try {
            if(!doesFolderExists()){
                TerminalPrinter.printMessage("Folder " + directory + " does not exist. No file was created");
            } else
            if (doesFileExists()) {
                TerminalPrinter.printMessage("File " + fileName + " already exists on path " + directory);
            } else {
                TerminalPrinter.printMessage("File " + fileName + " does not exist. Trying to create it...");
                Files.createFile(getAbsolutePath()); // creates the actual file
                TerminalPrinter.printMessage("File " + fileName + " created successfully");
            }
        } catch (Exception e) {
            TerminalPrinter.printMessage("An error has occureed while creating " + directory + ": ");
        }
    }

    // Returns true if the folder exists from that path
    public boolean doesFolderExists() {
        Path dir = Paths.get(directory);
        return Files.exists(dir) && Files.isDirectory(dir);
    }

    // Returns true if the file exists on a given directory
    public boolean doesFileExists() {
        return Files.exists(getAbsolutePath());
    }

    // checks if the file has a .json extension
    public boolean isTheFileJson(){
        return fileName.endsWith(".json");
    }

    // Returns the absolut path as a string
    public String getAbsoluteFilePathAsString(){
        return directory + "\\" + fileName;
    }

    // Returns the absolut path as a Path object
    public Path getAbsolutePath(){
        return Paths.get(getAbsoluteFilePathAsString());
    }

    // Returns the content of the file as String
    public String getFileAsSingleString(){
        Path path = getAbsolutePath();

        try {
            return Files.readString(path);
        } catch (Exception e) {
            TerminalPrinter.printMessage("Could not read file: ");
            e.printStackTrace();
            return null; // TODO how do I treat this better? Maybe create an exception?
        }
    }


}
