package com.Low_Cost.parser;

import java.io.File;

/**
 * Created by Study on 12.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(System.getProperty("catalina.home"));

        File file =
                new File("C:\\workspace\\apache-tomcat-8.0.33\\resources\\newFolder\\qwe");


        file.mkdirs();
    }

}
