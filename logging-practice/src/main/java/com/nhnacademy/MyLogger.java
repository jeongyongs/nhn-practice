package com.nhnacademy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {

    private static final Logger logger = Logger.getLogger("New");

    private MyLogger() {}

    public static Logger getLogger() {
        logger.setLevel(Level.INFO);
        return logger;
    }
}
