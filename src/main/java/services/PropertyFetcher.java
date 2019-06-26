package services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFetcher {

    private Properties appProperties;

    public PropertyFetcher() {
        appProperties = new Properties();
        try {
            appProperties.load(new FileInputStream("config/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getenv(String key) {
        return appProperties.getProperty(key);
    }

}
