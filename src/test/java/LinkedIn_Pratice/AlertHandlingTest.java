package LinkedIn_Pratice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertHandlingTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}

	@Test(priority = 1, description = "Handle Simple Alert")
	public void simpleAlertTest() {
		driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

		Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = simpleAlert.getText();

		simpleAlert.accept();

		Assert.assertEquals(alertText, "I am a JS Alert", "Simple alert text mismatch");

	}

	@Test(priority = 2, description = "Handle Confirmation Alert")
	public void confirmAlertTest() {
		driver.findElement(By.xpath("//*[text()=\"Click for JS Confirm\"]")).click();

		Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText = confirmAlert.getText();

		confirmAlert.dismiss();

		WebElement result = driver.findElement(By.xpath("//*[@id=\"result\"]"));
		Assert.assertTrue(result.getText().contains("Cancel"), "Cancel action not recorded");
	}

	@Test(priority = 3, description = "Handle Prompt Alert")
	public void promptAlertTest() {
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

		Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
		promptAlert.sendKeys("Yohan testing");
		promptAlert.accept();

		WebElement result = driver.findElement(By.id("result"));
		// Assert.assertTrue(result.getText().contains("Yohan Testing"),"Prompt text not
		// displayed correctly");
	}

	public void tearDown() {
		driver.quit();
	}

}
