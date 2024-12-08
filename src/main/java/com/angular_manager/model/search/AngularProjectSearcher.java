package com.angular_manager.model.search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONObject;

import com.angular_manager.model.entities.ProjectInfomationJsonModel;
import com.angular_manager.model.enums.FileName;
import com.angular_manager.model.exception.ThreadRunningException;
import com.angular_manager.model.json.JsonManipulator;
import com.angular_manager.model.util.TerminalPrinter;

import io.reactivex.rxjava3.subjects.ReplaySubject;

/**
 * Class that handles operations related to project searches. 
 * It uses an implementation of a ReactiveX library called RxJava that work on
 * observables and data streams. The search is done on a second thread
 * as not to block the main JavaFX thread, otherwise the screen will freeze.
 */
public class AngularProjectSearcher implements Runnable {

    /**
     * Only one thread will exist for the entire class
     */
    private static Thread searchThread;

    /**
     * Replay subject is a hot observable that emits all values pushed to it. This is a
     * good choice because it emits all the values on it, even for later subscribers
     */
    public static final ReplaySubject<ProjectInfomationJsonModel> angularProjectsFoundSubject = ReplaySubject.create();
    

    @Override
    public void run() {
        synchronized (AngularProjectSearcher.class) {

            // if the thread reference is null AND the thread is already running:
            if(searchThread != null && searchThread.isAlive()) {
                throw new ThreadRunningException("Thread is alraedy running");            
            }

            searchThread = new Thread(() -> {
                try {
                    searchForAngularProject();
                    TerminalPrinter.printMessage("Project Searcher Thread is running...");
                } finally {
                    searchThread = null;
                }
            });
            
            searchThread.setDaemon(true);
            searchThread.start();
        }
    }


    /*
     * Traverses the file tree recursively for folders that can contain an Angular project.
     * For each folder that mets the criteria the angularProjectsFoundSubject observable gets
     * an item, with information regarding the said project.
     */
    public static void searchForAngularProject() {

        try {
            // variable that adds the id for each object, since I'm using a lambda expression I need to use this
            AtomicInteger id = new AtomicInteger(1); // TODO move this to the config file

            Files.walk(Paths.get("W:\\")).forEach(path -> {
                if (Files.isDirectory(path) && isFolderAnAngularProject(path)) {
                    pushItemToReplaySubject(createFromPath(path, id.get()));
                    id.incrementAndGet();
                }
            });

        } catch (IOException e) {
            TerminalPrinter.printMessage("An unknown error has occured");
            e.printStackTrace();
        }
    }


    private static void pushItemToReplaySubject(ProjectInfomationJsonModel dto) {
        angularProjectsFoundSubject.onNext(dto);
    }


    /*
     * Returns true if and only if the given folder path contains an angular project.
     * The evaluation is done by some criteria like if the file has an angular.json or
     * package.json file. Other criteria may be added in the future.
     */
    private static boolean isFolderAnAngularProject(Path folder) {

        // I can add multiple criteria here, for now I'm considering only these
        Path angular = folder.resolve(FileName.ANGULAR_JSON.getName());
        Path packageJson = folder.resolve(FileName.PACKAGE_JSON.getName());

        return Files.exists(packageJson) && Files.exists(angular);
    }


    private static void printOnTerminal(ProjectInfomationJsonModel dto){
        System.out.println(dto);
    }


    private static ProjectInfomationJsonModel createFromPath(Path path, int id){

        // read the package.json and get the name of the project
        JsonManipulator packageJsonManipulator = new JsonManipulator(path.toString(), FileName.PACKAGE_JSON);
        JSONObject packageJson = new JSONObject(packageJsonManipulator.getFileAsSingleString());     

        // create the dto and return it
        ProjectInfomationJsonModel dto = new ProjectInfomationJsonModel();
        dto.setId(id);
        dto.setProjectName(packageJson.getString("name"));
        dto.setProjectPath(path.toString());

        printOnTerminal(dto);
        return dto;
    }




}
