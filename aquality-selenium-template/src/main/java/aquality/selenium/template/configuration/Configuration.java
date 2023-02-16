package aquality.selenium.template.configuration;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;

public class Configuration {

    private Configuration() {
    }

    public static String getStartUrl() {
        return Environment.getCurrentEnvironment().getValue("/startUrl").toString();
    }

    public static String getApiUrl() {
        return Environment.getCurrentEnvironment().getValue("/apiUrl").toString();
    }

    public static String getProjectName() {
        return Environment.getCurrentEnvironment().getValue("/project_name").toString();
    }

    public static Integer getBuildNumber() {
        return (Integer.parseInt(Environment.getCurrentEnvironment().getValue("/build_number").toString()));
    }

    public static String getEnvironmentName(){
        return Environment.getEnvName();
    }

    public static String getBrowserName(){
        return (String) AqualityServices.get(ISettingsFile.class).getValue("/browserName");
    }

    public static String getDBUrl() {
        return Environment.getCurrentEnvironment().getValue("/db_url").toString();
    }

    public static String getDBUserName() {
        return Environment.getCurrentEnvironment().getValue("/db_username").toString();
    }

    public static String getDBPassword() {
        return Environment.getCurrentEnvironment().getValue("/db_password").toString();
    }
}
