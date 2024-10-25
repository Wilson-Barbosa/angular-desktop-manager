package com.angular_manager.model.json;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.angular_manager.enums.FileName;
import com.angular_manager.util.TerminalPrinter;

/**
 * Class that performs operations on the JSON files
 */
public class JsonManipulator {

    private final Path folderPath;
    private final Path filePath;

    // Used for printing on the console
    private final String directory; 
    private final String fileName; 

    // Constructor
    public JsonManipulator(String directory, FileName fileName) {
        this.directory = directory;
        this.fileName = fileName.getName();
        this.folderPath = Paths.get(directory);
        this.filePath = Paths.get(directory, fileName.getName());
    }

    // Creates an empty folder
    public void createFolder() {
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

    /*
     * Creates a file inside the directory (if it exists that is)
     * By default the file will be empty
     */
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
        return Files.exists(folderPath) && Files.isDirectory(folderPath);
    }

    public boolean doesFileExists() {
        return Files.exists(filePath);
    }

    public boolean isTheFileJson(){
        return fileName.endsWith(".json");
    }

    public String getAbsoluteFilePathAsString(){
        return filePath.toString();
    }

    public Path getAbsolutePath(){
        return filePath;
    }

    // Returns the file's content as String
    public String getFileAsSingleString(){
        try {
            return Files.readString(filePath);
        } catch (Exception e) {
            TerminalPrinter.printMessage("Could not read file: ");
            e.printStackTrace();
            return null;
        }
    }

    public void writeIntoFileByTruncanting(byte[] byteArray, Path path){
        try {
            TerminalPrinter.printMessage("Trying to save new file...");
            Files.write(path, byteArray, StandardOpenOption.TRUNCATE_EXISTING);
            TerminalPrinter.printMessage("File saved successfully on " + getAbsoluteFilePathAsString());
        } catch (Exception e) {
            TerminalPrinter.printMessage("Could not write into " + getAbsoluteFilePathAsString() + " :");
            e.printStackTrace();
        }
    }


}
