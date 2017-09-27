package com.acme.edu;

public class Logger {

    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";

    public static void log(int message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        System.out.println(CHAR + message);
    }

    public static void log(String message) {
        System.out.println(STRING + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE + message);
    }
}