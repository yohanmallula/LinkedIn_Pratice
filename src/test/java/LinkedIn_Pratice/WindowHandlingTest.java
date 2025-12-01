package LinkedIn_Pratice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandlingTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1, description = "Switch to new window and verify text")
	public void windowSwitchTest() {

		driver.get("https://the-internet.herokuapp.com/windows");
		String parentID = driver.getWindowHandle();
		System.out.println("Parent Window ID: " + parentID);

		driver.findElement(By.linkText("Click Here")).click();

		Set<String> allWindows = driver.getWindowHandles();

		String childID = null;

		for (String id : allWindows) {
			if (!id.equals(parentID)) {
				childID = id;
			}
		}

		driver.switchTo().window(childID);
		System.out.println("Switched to child window: " + driver.getTitle());

		String text = driver.findElement(By.tagName("h3")).getText();
		Assert.assertTrue(text.contains("New Window"), "Text not found in new window!");

		driver.close();

		driver.switchTo().window(parentID);
		Assert.assertTrue(driver.getTitle().contains("The Internet"), "Failed to switch back to parent window");
	}

	@Test(priority = 2, description = "Open new tab using JavaScript and validate URL")
	public void openNewTabTest() {
		String parentID = driver.getWindowHandle();

		// open the new tab via java script
		((JavascriptExecutor) driver).executeScript("window.open('https://www.google.com','_blank');");

		Set<String> windows = driver.getWindowHandles();

		for (String id : windows) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
			}
		}

		Assert.assertTrue(driver.getCurrentUrl().contains("google"), "Failed to switch to new tab!");

		driver.close();

		driver.switchTo().window(parentID);
	}

	public void teraDown() {
		driver.quit();
	}

}
