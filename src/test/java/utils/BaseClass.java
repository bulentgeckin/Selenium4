package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static java.lang.System.setProperty;
import static utils.MySystem.webDriverPath;

public class BaseClass {

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());
    public static WebDriver driver;

    public static WebDriver initializeWebDriver() {

        // Read default paramaters from Constant class
        ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);


        String browser = ConfigsReader.getProperty("browser").toLowerCase();

        // Check Maven runtime options | mvn test -Dbrowser=<browser> |
        String mavenOption = System.getProperty("browser");

        if (!(mavenOption == null)) {
            browser = System.getProperty("browser");
            log.info("System Property  (browser)     :" + "[" + mavenOption + "]");
        }

        boolean silent = false;

        if (ConfigsReader.getProperty("headless").contentEquals("true"))
            silent = true;

        String chromeDriver = Constants.WEB_DRIVERS_PATH + "chromedriver";
        String firefoxDriver = Constants.WEB_DRIVERS_PATH + "geckodriver";
        String edgeDriver = Constants.WEB_DRIVERS_PATH + "msedgedriver";

        if (Constants.OS_NAME.contains("Windows")) {
            chromeDriver = chromeDriver + ".exe";
            firefoxDriver = firefoxDriver + ".exe";
            edgeDriver = edgeDriver + ".exe";
        }

        switch (browser) {

            case "chrome":
                setProperty("webdriver.chrome.driver", chromeDriver);
                ChromeOptions chromeOptions = new ChromeOptions();
                setProperty("webdriver.chrome.args", "--disable-logging");
                setProperty("webdriver.chrome.silentOutput", "true");

                // to make the Chrome browser totally silent
                if (silent)
                    chromeOptions.addArguments("--headless");

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                setProperty("webdriver.gecko.driver", firefoxDriver);

                // to make the firefox browser totally silent
                if (silent) {
                    FirefoxBinary firefoxBinary = new FirefoxBinary();
                    firefoxBinary.addCommandLineOptions("--headless");

                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setBinary(firefoxBinary);
                    driver = new FirefoxDriver(firefoxOptions);
                } else
                    driver = new FirefoxDriver();

                break;

            case "edge":
                setProperty("webdriver.edge.driver", edgeDriver);


                // to make the firefox browser totally silent
                if (silent) {
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--headless");
                    driver = new EdgeDriver(edgeOptions);
                } else
                    driver = new EdgeDriver();

                break;

            default:
                System.err.println("Browser is not supported, check your parameter");
                System.exit(0);
        }


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICITLY_LOAD_TIME));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        log.info("Platform                            : [" + Constants.OS_NAME + "]");
        log.info("Driver Initialized  Successfully    : [true]");
        log.info("Browser  / silent?                  : [" + browser + "] [" + silent + "]");


        return driver;
    }

    public static void gotoWebPage(String url) {

        try {
            driver.get(url);

            if (driver.getCurrentUrl().contains(url)) {
                log.info("Successfully landed the web page    : [" + url + " }");
            }


        } catch (Exception e) {
            log.info("Can not navigate the url            : [" + url + " }");
            closeWebDriver();
        }


    }


    public static void closeWebDriver() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (driver != null) {
            driver.quit();
            log.info("Web driver terminated successfully   : [true]");

        }
    }

}
