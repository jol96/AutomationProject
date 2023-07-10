package api.stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseSteps {
    protected Properties configProperties;
    protected String BaseApi;

    public void getConfiguation(){
        try (FileInputStream configFile = new FileInputStream("config.properties")) {
            configProperties = new Properties();
            configProperties.load(configFile);
            BaseApi = configProperties.getProperty("BaseApi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

