package aquality.selenium.template.configuration;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

class Environment {

    private Environment() {
    }

    static ISettingsFile getCurrentEnvironment() {
        String envName = (String) AqualityServices.get(ISettingsFile.class).getValue("/environment");
        Path resourcePath = Paths.get("environment", envName, "config.json");
        return new JsonSettingsFile(resourcePath.toString());
    }

    static String getEnvName(){
        return (String) AqualityServices.get(ISettingsFile.class).getValue("/environment");
    }

    static String getComputerName()
    {
        Map<String, String> env = System.getenv();
        if (env.containsKey("COMPUTERNAME"))
            return env.get("COMPUTERNAME");
        else if (env.containsKey("HOSTNAME"))
            return env.get("HOSTNAME");
        else
            return "Unknown Computer";
    }
}
