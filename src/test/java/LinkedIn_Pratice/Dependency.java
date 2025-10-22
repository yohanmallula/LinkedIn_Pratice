
package LinkedIn_Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dependency {

	WebDriver driver;

	@BeforeClass(description = "setup chrome browser and open OrangeHRM demo site")
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test(priority = 1, description = "Login with valid credentails")
	public void loginTest() {

		driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).submit();

		WebElement dashBroard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		Assert.assertTrue(dashBroard.isDisplayed(), "Dashboard should be visible after login");

	}

	@Test(priority = 2, dependsOnMethods = "loginTest", description = "Verify dashboard elements after login")
	public void dashboardTest() {

		WebElement timeAtWork = driver.findElement(By.xpath("//*[text()='Time at Work']"));
		WebElement quickLunch = driver.findElement(By.xpath("//p[text()='Quick Launch']"));

		Assert.assertTrue(timeAtWork.isDisplayed(), "Time at Work section should be visible");
		Assert.assertTrue(quickLunch.isDisplayed(), "Quick Launch section should be visible");
	}

	@Test(priority = 3, dependsOnMethods = "loginTest")
	public void logout() {
		WebElement logout = driver.findElement(By.xpath("//*[@class=\"oxd-userdropdown-tab\"]"));

		logout.click();

		driver.findElement(By.xpath("//*[text()='Logout']")).click();
	}

}
