package webdriver;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class TestWebDriver {

    @Test
    public void testChromeBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "d:/webdrivers/chrome/104/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


        String url = "https://www.google.com/";

        driver.get(url);
        driver.manage().window().fullscreen();

        String currentUrl = driver.getCurrentUrl();
        String currentTitle=driver.getTitle();

        assertEquals(currentUrl, url);
        assertEquals(currentTitle, "Google");

        Thread.sleep(4000);

        driver.quit();

    }

}