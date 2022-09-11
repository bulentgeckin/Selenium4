package webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.MySystem;
import java.time.Duration;

public class TestWebDrivers {


    public static void setTimeouts(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    public static void testChromeBrowser() throws Exception {

        System.setProperty("webdriver.chrome.driver", MySystem.webDriverPath("chrome"));
        WebDriver driver = new ChromeDriver();
        setTimeouts(driver);
        driver.get("https://www.google.com/");
        driver.manage().window().fullscreen();
        System.out.println("Tile       :" + driver.getTitle());
        Thread.sleep(4000);
        driver.quit();
    }

    public static void testFireFoxBrowser() throws Exception {

        System.setProperty("webdriver.gecko.driver", MySystem.webDriverPath("firefox"));
        WebDriver driver = new FirefoxDriver();
        setTimeouts(driver);
        driver.get("https://www.mozilla.org");
        driver.manage().window().fullscreen();
        System.out.println("Tile       :" + driver.getTitle());
        Thread.sleep(4000);
        driver.quit();
    }

    public static void testEdgeBrowser() throws Exception {

        System.setProperty("webdriver.edge.driver", MySystem.webDriverPath("edge"));
        WebDriver driver = new EdgeDriver();
        setTimeouts(driver);
        driver.get("https://www.microsoft.com");
        driver.manage().window().fullscreen();
        System.out.println("Title       :" + driver.getTitle());
        Thread.sleep(4000);
        driver.quit();
    }

}