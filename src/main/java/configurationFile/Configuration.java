package configurationFile;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Configuration {
    Properties propertiesObj = new Properties();
    public void loadProperty ( String filePath) throws Exception{
        File propertyFile = new File(filePath);
        FileReader fileReader = new FileReader(propertyFile);
        propertiesObj.load(fileReader);
    }
    public String getProperty (String propertyType) {
    return propertiesObj.getProperty(propertyType);
    }


    public static void main(String[] args) throws Exception{
        Configuration propertyReader = new Configuration();
        propertyReader.loadProperty("D:\\JavaPractice\\JavaPractice\\config.properties");
        String value = propertyReader.getProperty("Browser");
        System.out.println(value);
    }
}

