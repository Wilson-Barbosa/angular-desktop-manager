package com.angular_manager.model.command;

import com.angular_manager.model.exception.CommandLineException;

public interface CommandWritterInterface {
    public void writeCommand(String command) throws CommandLineException;
}
