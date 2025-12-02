package LinkedIn_Pratice;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FluentWaitPracticeTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1, description = "Create custom wait to check element text change")
	public void fluentWaitTest() {

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.xpath("//div[@id='start']/button")).click();

		// create fluentWait

		Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);

		// Wait for the heloo world message
		WebElement helloText = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.id("finish"));
				if (element.isDisplayed()) {
					return element;
				} else {
					return null;
				}
			}
		});

		String text = helloText.getText();
		System.out.println("FluentWait Result: " + text);

		Assert.assertEquals(text, "Hello World!", "Text not loaded correctly!");

	}

	@Test(priority = 2, description = "Create custom wait to check element text change")
	public void customWaitConditionTest() {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

		driver.findElement(By.xpath("//div[@id='start']/button")).click();

		Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(12)).pollingEvery(Duration.ofMillis(400))
				.ignoring(NoSuchElementException.class);

		/*
		 * WebElement element = wait.until(driver -> { WebElement e =
		 * driver.findElement(By.id("finish")); if (!e.getText().isEmpty()) { return e;
		 * } return null; });
		 * 
		 * System.out.println("Custom Wait Result: " + element.getText());
		 * Assert.assertTrue(element.getText().contains("Hello World"));
		 */
	}

	public void tearDown() {
		driver.quit();
	}

}
