package com.angular_manager.model.config;

import com.angular_manager.model.enums.FileName;
import com.angular_manager.model.exception.UnsupportedOSException;
import com.angular_manager.model.json.AngularProjectJsonManipulator;
import com.angular_manager.model.json.ConfigurationJsonManipulator;

/**
 * This class is responsible for managing the app's configuration. Because this is a configuration
 * class, it implements the singleton pattern.
 */
public final class Environment {

    private static AngularProjectJsonManipulator angularListManipulator;
    private static ConfigurationJsonManipulator configurationManipulator;
    private static final Environment SINGLE_INSTANCE = new Environment();

    private Environment() {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System is: " + os);
        if (os.equals("linux")) {
            setLinuxEnvironment();
        } else if (os.equals("windows")) {
            setWindowsEnvironment();
        } else {
            throw new UnsupportedOSException("Operating System not supported: " + os);
        }
    }

    /** Returns the single instance of Environment class*/
    public static Environment setupEnvironment(){
        return SINGLE_INSTANCE;
    }

    private static void setLinuxEnvironment(){
        String homeDir = System.getProperty("user.home");        
        angularListManipulator = new AngularProjectJsonManipulator(homeDir + "/.config/angular-manager", FileName.ANGULAR_JSON);
        angularListManipulator.createFolder();
        angularListManipulator.createFile();

        configurationManipulator = new ConfigurationJsonManipulator(homeDir + "/.local/share/angular-manager/", FileName.CONFIGURATION_JSON);
        configurationManipulator.createFolder();
        configurationManipulator.createFile();
    }

    private void setWindowsEnvironment() {
        
    }

    public static AngularProjectJsonManipulator getAngularListManipulator() {
        return angularListManipulator;
    }

    public static ConfigurationJsonManipulator getConfigurationManipulator() {
        return configurationManipulator;
    }

    /** Returns the Operating System's name as a string */
    public static String getOs() {
        return System.getProperty("os.name").toLowerCase();
    }

    
}
