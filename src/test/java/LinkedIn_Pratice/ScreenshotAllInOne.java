
package LinkedIn_Pratice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class ScreenshotAllInOne {

	WebDriver driver;
	WebDriverWait wait;

	
    @BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));

		driver.get("https://www.saucedemo.com/");

	}

	public String captureFullPage(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String path = System.getProperty("user.dir") + "/screenshots/" + fileName + "_" + timestamp + ".png";

		try {
			FileUtils.copyFile(src, new File(path));

		} catch (IOException e) {
			System.out.print(e.getMessage());
		}

		return path;

	}

	public String captureElementScreenshot(WebElement element, String fileName) {
		File src = element.getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path = System.getProperty("user.dir") + "/screenshots/" + fileName + "_" + timestamp + ".png";

		try {
			FileUtils.copyFile(src, new File(path));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return path;
	}

	@Test(priority = 1, description = "Take full screenshot of login page")
	public void fullPageScreenshotTest() {
		captureFullPage("Login_Page");
	}

	@Test(priority = 2, description = "Take screenshot of the SauceDemo logo")
	public void elementScreenshotTest() {
		WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login_logo")));
		captureElementScreenshot(logo, null);
	}

	public void tearDown() {
		driver.quit();
	}

}
