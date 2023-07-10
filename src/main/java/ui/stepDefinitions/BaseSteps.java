package ui.stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public abstract class BaseSteps {

    protected static final Logger LOGGER = Logger.getLogger(BaseSteps.class.getName());
    protected Properties configProperties;
    protected String browser;
    protected String runHeadless;

    public void getConfiguation(){
        try (FileInputStream configFile = new FileInputStream("config.properties")) {
            configProperties = new Properties();
            configProperties.load(configFile);
            browser = configProperties.getProperty("Browser");
            runHeadless = configProperties.getProperty("RunHeadless");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
