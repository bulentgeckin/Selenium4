package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 *
 *  This code automatically downloads 'Chrome Web Driver Binary' from Google repository
 *
 */

class TestWebDriverDownloadWebDriver {

    public WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void googleSearch() {

        driver.get("https://www.google.com");
        driver.manage().window().fullscreen();
        assertTrue(driver.getCurrentUrl().contains("google"));
        assertEquals(driver.getCurrentUrl(), "https://www.google.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButtonImfeelingLucky = driver.findElement(By.name("btnI"));

        searchBox.sendKeys("Selenium");
        searchButtonImfeelingLucky.click();

        System.out.println(driver.getCurrentUrl());

    }
}