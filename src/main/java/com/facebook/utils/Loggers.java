package com.facebook.utils;

import org.apache.log4j.Logger;

public class Loggers {
    private static final Logger log = Logger.getLogger(Loggers.class.getName());

    // This is to print log for the beginning of the test case, as we usually
    // run so many test cases as a test suite
    public static void startTestCase(String sTestCaseName) {
        log.info("************************************************************************************");
        System.out.println("************************************************************************************");
        log.info("$$$$$$$$$$$$$$$$$$$              " + sTestCaseName + "           $$$$$$$$$$$$$$$$$$$");
        System.out.println("$$$$$$$$$$$$$$$$$$$              " + sTestCaseName + "           $$$$$$$$$$$$$$$$$$$");
        log.info("************************************************************************************");
        System.out.println("************************************************************************************");
    }

    // This is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName) {
        log.info("XXXXXXXXXXXXXXXXXXXXX            " + "-E---N---D-"
                + "            XXXXXXXXXXXXXXXXXXX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXX            " + "-E---N---D-"
                + "            XXXXXXXXXXXXXXXXXXX");
        log.info("X");
        System.out.println("X");
        log.info("X");
        System.out.println("X");
        log.info("X");
        System.out.println("X");
    }

    public static void info(String message) {
        log.info(message);
        System.out.println(message);
    }

    public static void info(String message, String text) {
        log.info(message);
        System.out.println(message);
        System.out.println(text);

    }

    public static void warn(String message) {
        System.out.println("==============Warning==============");
        log.warn(message);
        System.out.println(message);
    }

    public static void error(String message) {
        System.out.println("==============Error==============");
        log.error(message);
        System.out.println(message);
    }

    public static void fatal(String message) {
        System.out.println("==============Fatal==============");
        log.fatal(message);
        System.out.println(message);
    }

    public static void debug(String message) {
        System.out.println("==============Debug==============");
        log.debug(message);
        System.out.println(message);
    }

}
