package utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
    public static String read(String key)  {
        String filePath = Constants.CONFIG_FILE_PATH;
        Properties properties=new Properties();
        try(FileInputStream fis=new FileInputStream(filePath)){
            properties.load(fis);
        }
        catch (FileNotFoundException e){
            System.out.println("File not found: " + filePath);

        }
        catch (IOException io){
            System.out.println("Error reading the file: " + filePath);
        }

        // print the value associated with the key "userName"
        return properties.getProperty(key);
    }
}

