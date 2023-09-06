package com.nhnacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogback {

    private static final Logger logger = LoggerFactory.getLogger(MyLogback.class);

    private MyLogback() {}

    public static Logger getLogger() {
        return logger;
    }
}
