package com.angular_manager.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONObject;

import com.angular_manager.model.DTO.ProjectListItemDTO;
import com.angular_manager.model.enums.FileName;
import com.angular_manager.model.json.JsonManipulator;
import com.angular_manager.model.util.TerminalPrinter;

import io.reactivex.rxjava3.subjects.ReplaySubject;

public class AngularProjectSearcher {

    // Replay subject is a hot observable that emits all values pushed to it. This is a
    // good choice because it emits all the values it stored, even for later subscribers
    public static final ReplaySubject<ProjectListItemDTO> angularProjectsFound = ReplaySubject.create();

    /*
     * Traverses the file tree recursively for folders that can contain an Angular project
     * Each folder that mets the criteria I create a DTO that gets pushed to the subject
     */
    public static void searchForAngularProject() {
        try {
            // variable that adds the id for each object, since I'm using a lambda expression I need to use this
            AtomicInteger id = new AtomicInteger(1); 

            Files.walk(Paths.get("W:\\")).forEach(path -> {

                if (Files.isDirectory(path) && isFolderAnAngularProject(path)) {
                    pushItemToReplaySubject(buildDTOFromPath(path, id.get()));
                    id.incrementAndGet();
                }
            });

        } catch (IOException e) {
            TerminalPrinter.printMessage("An unknown error has occured");
            e.printStackTrace();
        }
    }

    private static void pushItemToReplaySubject(ProjectListItemDTO dto) {
        angularProjectsFound.onNext(dto);
    }

    // Returns true if and only if all criteria is met
    private static boolean isFolderAnAngularProject(Path folder) {

        // I can add multiple criteria here, for now I'm considering only these
        Path angular = folder.resolve(FileName.ANGULAR_JSON.getName());
        Path packageJson = folder.resolve(FileName.PACKAGE_JSON.getName());

        return Files.exists(packageJson) && Files.exists(angular);
    }

    private static void printDTO(ProjectListItemDTO dto){
        System.out.println(dto);
    }


    private static ProjectListItemDTO buildDTOFromPath(Path path, int id){

        // read the package.json and get the name of the project
        JsonManipulator packageJsonManipulator = new JsonManipulator(path.toString(), FileName.PACKAGE_JSON);
        JSONObject packageJson = new JSONObject(packageJsonManipulator.getFileAsSingleString());     

        // create the dto and return it
        ProjectListItemDTO dto = new ProjectListItemDTO();
        dto.setId(id);
        dto.setProjectName(packageJson.getString("name"));
        dto.setProjectPath(path.toString());

        printDTO(dto);
        return dto;
    }


}
