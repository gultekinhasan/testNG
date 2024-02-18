package com.eurotech.utilities;
import java.util.Properties;
import java.io.FileInputStream;
public class ConfigurationReader {
    private static Properties properties; //encapsulation

    static {

        try {
            // which file to read
            String path = "configuration.properties";
            // read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path);
            // properties --> class that store properties in key / value format
            properties = new Properties();
            // the values from the file input is loaded / fed in to the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    // how can we call the ConfigurationReader
    public static String get(String keyName){

        return properties.getProperty(keyName);
    }
}