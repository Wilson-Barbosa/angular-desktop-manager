package com.angular_manager.util;

public abstract class TerminalPrinter {
    
    public static void printMessage(String message){
        System.out.println(" - [Angular Manager]: " + message);
    }

}
