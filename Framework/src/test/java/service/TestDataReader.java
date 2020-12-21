package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));


    public static String getTestData(String key){
        if(resourceBundle == null)
            return ResourceBundle.getBundle("dev").getString(key);
        return resourceBundle.getString(key);
    }

}
