package com.angular_manager.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.angular_manager.DTO.ProjectListItemDTO;
import com.angular_manager.model.json.JsonManipulator;
import com.angular_manager.util.TerminalPrinter;

import io.reactivex.rxjava3.subjects.ReplaySubject;

public class AngularProjectSearcher {

    // Replay subject is a hot observable that emits all values pushed to it
    // this is a good choice because it emits all the values it stored, even for
    // later subscribers
    public static final ReplaySubject<ProjectListItemDTO> angularProjectsFound = ReplaySubject.create();

    /*
     * Traverses the fileSystem for folders that can contain an Angular project
     * Each folder that mets the criteria I create a DTO that gets pushed to the
     * subject
     */
    public static void searchForAngularProject() {
        try {
            int id = 1;

            Files.walk(Paths.get("W:\\")).forEach(path -> {

                if (Files.isDirectory(path) && isFolderAnAngularProject(path)) {
                    
                }

            });

        } catch (IOException e) {
            TerminalPrinter.printMessage("An unknown error has occured");
            e.printStackTrace();
        }
    }

    public static void pushItemToReplaySubject(ProjectListItemDTO dto) {
        angularProjectsFound.onNext(dto);
    }

    // Returns true if and only if all criteria is met
    public static boolean isFolderAnAngularProject(Path folder) {
        // I can add multiple criteria here, for now I'm considering only these
        Path angular = folder.resolve("angular.json");
        Path packageJson = folder.resolve("package.json");

        return Files.exists(packageJson) && Files.exists(angular);
    }

    public void printDTO(ProjectListItemDTO dto){
        System.out.println(dto);
    }


    public ProjectListItemDTO buildDTO(Path path){

        // JsonManipulator = new JsonManipulator(path, "angular.json");



        ProjectListItemDTO dto = new ProjectListItemDTO();
        return dto;
    }

}
