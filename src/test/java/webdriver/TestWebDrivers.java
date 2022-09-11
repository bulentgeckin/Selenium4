package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

import static java.lang.System.setProperty;
import static utils.MySystem.webDriverPath;


public class TestWebDrivers {


    public static void setTimeouts(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    public static void printAndExit(WebDriver driver) throws InterruptedException {
        System.out.println("Title       :" + driver.getTitle());
        Thread.sleep(4000);
        driver.quit();
    }


    public static void testChromeBrowser() throws Exception {
        setProperty("webdriver.chrome.driver", webDriverPath("chrome"));
        WebDriver driver = new ChromeDriver();
        setTimeouts(driver);
        driver.get("https://www.google.com/");
        printAndExit(driver);
    }


    public static void testFireFoxBrowser() throws Exception {
        setProperty("webdriver.gecko.driver", webDriverPath("firefox"));
        WebDriver driver = new FirefoxDriver();
        setTimeouts(driver);
        driver.get("https://www.mozilla.org");
        printAndExit(driver);
    }


    public static void testEdgeBrowser() throws Exception {
        setProperty("webdriver.edge.driver", webDriverPath("edge"));
        WebDriver driver = new EdgeDriver();
        setTimeouts(driver);
        driver.get("https://www.microsoft.com");
        printAndExit(driver);

    }

}