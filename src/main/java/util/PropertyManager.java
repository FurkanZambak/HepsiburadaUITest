package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager propertyInstance;
    private static final Object lock = new Object();
    private static String configPath = "config.properties";
    private static String browserType;
    private static String appURL;
    private static int implicitWaitDuration;

    public static PropertyManager getInstance() {
        if(propertyInstance == null) {
            synchronized (lock) {
                propertyInstance = new PropertyManager();
                propertyInstance.initializePropertyFile();
            }
        }
        return propertyInstance;
    }

    private void initializePropertyFile() {
        Properties property = new Properties();
        try {
            InputStream inputStream = new FileInputStream(configPath);
            property.load(inputStream);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        browserType = property.getProperty("BrowserType");
        appURL = property.getProperty("AppURL");
        implicitWaitDuration = Integer.parseInt(property.getProperty("ImplicitWaitDuration"));
    }

    public String getBrowserType() {
        return browserType;
    }

    public String getAppURL() {
        return appURL;
    }

    public int getImplicitWaitDuration() {
        return implicitWaitDuration;
    }
}
