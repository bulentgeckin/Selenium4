//package practice;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//
//public class FileDownload {
//
//	public static void main(String[] args) throws InterruptedException, IOException {
//
//		String currentPath = System.getProperty("user.dir");
//
//		System.setProperty("webdriver.chrome.driver", currentPath+"/drivers/chromedriver.exe");
//
//		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//
//		chromePrefs.put("profile.default_content_settings.popups", 0);
//		chromePrefs.put("download.default_directory", currentPath);
//
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("prefs", chromePrefs);
//		WebDriver driver = new ChromeDriver(options);
//
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
//		driver.findElement(By.linkText("Download Now")).click();
//
//		Thread.sleep(5000);
//
//		File f = new File(currentPath + "/download.zip");
//
//		if (f.exists())
//
//		{
//
//			Assert.assertTrue(f.exists());
//
//			if (f.delete())
//
//				System.out.println("file deleted");
//
//		}
//
//	}
//
//}
