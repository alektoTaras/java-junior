package com.acme.edu;

import java.io.File;

import static com.acme.edu.Logger.*;
import static java.io.File.separator;
import java.io.File;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Java Coding Style Convention (PDF)
 */
public class Logger {
    public static final String MY_SUPER_CONSTANT = "";

    public static int globalState = 0;
    public int instanceState = 0;

    public static String ClassName = "";
    public static final String PRIM= "primitive: ";

    public static void log(byte foramlMessage) {
        String etalon = (new Byte(foramlMessage)).getClass().toString();
        if(!ClassName.equals(etalon)) {
            ClassName = etalon;
            System.out.println(PRIM+"\r\n" + foramlMessage);
        }else {
            System.out.println(foramlMessage);
        }
    }
    public static void log(int foramlMessage) {
        /*String etalon = (new Integer(foramlMessage)).getClass().toString();
        if(!ClassName.equals(etalon)) {
            ClassName = etalon;
            System.out.println("primitive: \r\n" + foramlMessage);
        }else {
            System.out.println(foramlMessage);
        }*/
        System.out.print(PRIM + foramlMessage+"\r\n");
    }
    public static void log(char foramlMessage) {
        String etalon = (new Character(foramlMessage)).getClass().toString();
        if(!ClassName.equals(etalon)) {
            ClassName = etalon;
            System.out.println("char: \r\n" + foramlMessage);
        }else {
            System.out.println(foramlMessage);
        }
    }
    public static void log(String foramlMessage) {
        String etalon = (new String(foramlMessage)).getClass().toString();
        if(!ClassName.equals(etalon)) {
            ClassName = etalon;
            System.out.println("string: \r\n" + foramlMessage);
        }else {
            System.out.println(foramlMessage);
        }
    }

    public static void log(Object obj) {
        String etalon = obj.getClass().toString();
        if(!ClassName.equals(etalon)) {
            ClassName = etalon;
            System.out.println("reference: \r\n" + '@');
        }else {
            System.out.println('@');
        }
    }

    public static void log(boolean foramlMessage) {
        String etalon = new Boolean(foramlMessage).getClass().toString();
        if(!ClassName.equals(etalon)) {
            ClassName = etalon;
            System.out.println("primitive: \r\n" + foramlMessage);
        }else {
            System.out.println(foramlMessage);
        }
    }

    /**
     * JavaDoc
     * <bold>kfdfgjkhdgjfdhg</bold>
     *
     * @param message РАПРапрдлпао апдлапорда рдаплро
     */
    /*public static void log(byte message) {
        System.out.println("primitive: " + message);
    }*/

    /**
     * public API
     */
   /* public static void log(String message) {
        System.out.println(message);
    }*/


    public static void main(String... args) {
        int local = 0;
        //kdjfhgkjfgh
        log(1);

        System.out.println(new String("").getClass().toString());
//        Main.main();
//        Main.counter = 1;
    }
}
/*
class Main {
    public static int counter = 0;

    static {
        System.out.println("Hello!");
        counter = 1;
    }

    public void m() {

    }

    /**
     * java -Xss2m -Xms4G -Xmx4G
     */
/*
    public static void main(String[] args) {
        int local = 0;
        main(new String[] {});

        int factualMessage = 1;
        Object o = new Object();

        System.out.println(factualMessage);
    }
}
*/