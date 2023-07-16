package org.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ProjectUtil {

    Properties prop= new Properties();

    public String getProperties(String key){
        try{
            InputStream location= new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/app.properties");

            prop.load(location);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
