package utils;

public class system {

    public static String webDriverPath(String browser) {

        String currentProjectDirectory = System.getProperty("user.dir");
        String webDriverPath = currentProjectDirectory + "/src/webDrivers/";


        switch (browser) {

            case "chrome":
                webDriverPath = webDriverPath + "chromedriver.exe";
                break;

            case "firefox":
                webDriverPath = webDriverPath + "geckodriver.exe";
                break;


        }


        return webDriverPath;


    }
}
