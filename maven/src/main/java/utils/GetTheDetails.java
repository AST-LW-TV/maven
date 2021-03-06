package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// gets the details from properties file
public class GetTheDetails {
    private static Properties prop = new Properties();
    private static FileInputStream file;

    static {
        try {
            file = new FileInputStream("./target/classes/config.properties");
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
            System.exit(-1); // unsuccessful termination
        }
    }

    // returns the value of that particular key passed
    public static String getValue(String key) {
        try {
            prop.load(file);
        } catch (IOException e) {
            System.out.println("File Error...");
            System.exit(-1);
        }
        return prop.getProperty(key);
    }
}