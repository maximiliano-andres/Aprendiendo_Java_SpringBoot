package com.Repasando.Java2025.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger {

    private static final Logger logger = LoggerFactory.getLogger("AppLogger");

    private static final String DEBUG_PREFIX = "\u001B[32m[DEBUG] %s - %s: %s\u001B[0m";
    private static final String INFO_PREFIX  = "\u001B[36m[INFO ] %s - %s: %s\u001B[0m";
    private static final String ERROR_PREFIX = "\u001B[31m[ERROR] %s - %s: %s\u001B[0m";

    public static void debug(Object message) {
        StackTraceElement caller = getCallerInfo();
        logger.debug(String.format(DEBUG_PREFIX, caller.getClassName(), caller.getMethodName(), message));
    }

    public static void info(Object message) {
        StackTraceElement caller = getCallerInfo();
        logger.info(String.format(INFO_PREFIX, caller.getClassName(), caller.getMethodName(), message));
    }

    public static void error(Object message) {
        StackTraceElement caller = getCallerInfo();
        logger.error(String.format(ERROR_PREFIX, caller.getClassName(), caller.getMethodName(), message));
    }

    private static StackTraceElement getCallerInfo() {
        // 0: Thread.getStackTrace, 1: getCallerInfo, 2: info/debug/error, 3: llamada real
        return Thread.currentThread().getStackTrace()[3];
    }
}
