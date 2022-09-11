package utils;

public class MySystem {

    public static String currentProjectDirectory() {

        return System.getProperty("user.dir");

    }


    public static String webDriverPath(String browser) {

        String webDriverPath = currentProjectDirectory() + "/src/test/resources/webDrivers/";


        switch (browser) {

            case "chrome":
                webDriverPath = webDriverPath + "chromedriver.exe";
                break;

            case "firefox":
                webDriverPath = webDriverPath + "geckodriver.exe";
                break;


            case "edge":
                webDriverPath = webDriverPath + "msedgedriver.exe";
                break;

            default:
                System.err.println("Browser is not provided or supported, check your parameter");
                System.exit(0);

        }


        return webDriverPath;


    }
}
