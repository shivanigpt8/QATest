package helpers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class configFileReader {

    String fileName;

    public configFileReader(String fileName)
    {
        this.fileName = fileName;
    }

    public String getPropertyFromFile(String properyName) {

        try {

            Properties prop = new Properties();
            InputStream input = new FileInputStream(fileName);
            prop.load(input);
            return prop.getProperty(properyName);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
