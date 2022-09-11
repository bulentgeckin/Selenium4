//package utils;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxBinary;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//public class BaseClass {
//
//    public static Logger log = LogManager.getLogger(BaseClass.class.getName());
//    public static WebDriver driver;
//
//    public static WebDriver driverSetup() {
//
//        ConfigsReader.readProperties(Constants.CREDENTIALS_FILEPATH);
//        String browser = ConfigsReader.getProperty("browser").toLowerCase();
//
//        // Check Maven runtime options | mvn test -Dbrowser=<browser> |
//        String mavenOption = java.lang.System.getProperty("browser");
//
//        if (!(mavenOption == null)) {
//            browser = java.lang.System.getProperty("browser");
//            log.info("System Property  (browser)     :" + "[" + mavenOption + "]");
//        }
//
//        Boolean silent = false;
//
//        if (ConfigsReader.getProperty("headless").contentEquals("true"))
//            silent = true;
//
//        String chromeDriverPath = Constants.CHROME_DRIVER_PATH;
//        String firefoxDriverPath = Constants.GECKO_DRIVER_PATH;
//
//        if (Constants.OS_NAME.contains("Windows")) {
//            chromeDriverPath = Constants.CHROME_DRIVER_PATH + ".exe";
//            firefoxDriverPath = Constants.GECKO_DRIVER_PATH + ".exe";
//        }
//
//        switch (browser) {
//
//            case "chrome":
//
//                java.lang.System.setProperty("webdriver.chrome.driver", chromeDriverPath);
//                ChromeOptions options = new ChromeOptions();
//                java.lang.System.setProperty("webdriver.chrome.args", "--disable-logging");
//                java.lang.System.setProperty("webdriver.chrome.silentOutput", "true");
//
//                // to make the browser totally silent
//                if (silent)
//                    options.addArguments("--headless");
//
//                driver = new ChromeDriver(options);
//                break;
//
//            case "firefox":
//
//                java.lang.System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
//                java.lang.System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
//                        Constants.USER_PATH + "/logs/fireFoxLog.txt");
//
//                // to make the browser totally silent
//                if (silent) {
//                    java.lang.System.out.println("********* firefox silent *********");
//                    FirefoxBinary firefoxBinary = new FirefoxBinary();
//                    firefoxBinary.addCommandLineOptions("--headless");
//
//                    FirefoxOptions firefoxOptions = new FirefoxOptions();
//                    firefoxOptions.setBinary(firefoxBinary);
//                    driver = new FirefoxDriver(firefoxOptions);
//                } else {
//
//                    driver = new FirefoxDriver();
//                }
//
//                break;
//
//            default:
//                java.lang.System.err.println("Browser is not supported, check your parameter");
//                java.lang.System.exit(0);
//        }
//
//
//        driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_LOAD_TIME, TimeUnit.SECONDS);
//        // driver.manage().window().maximize();
//        // driver.manage().deleteAllCookies();
//
//        log.info("Platform                       : [" + Constants.OS_NAME + "]");
//        log.info("Driver Initialized             : [OK]");
//        log.info("Browser                        : [" + browser + "] [" + silent + "]");
//
//        return driver;
//    }
//
//    public static void driverSetup(String url) {
//        // driver.get(ConfigsReader.getProperty("url"));
//        // read URL from /src/test/resources/Configuration.properties file
//        driver.get(url);
//
//    }
//
//    public static void tearDown() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//}
