package com.angular_manager.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class TerminalPrinter {

    private static final Logger logger = Logger.getLogger(TerminalPrinter.class.getName());
    
    public static void printMessage(String message){
        // logger.log(Level.INFO, "[Angular Manager]: " + message);
        System.out.println("[Angular Manager]: " + message);
    }

}
