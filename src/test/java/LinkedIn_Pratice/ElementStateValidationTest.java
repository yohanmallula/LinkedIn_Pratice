package LinkedIn_Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElementStateValidationTest {
	
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Test(priority =1, description = "Validate checkbox selection state")
	public void checkBoxStateTest() {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		WebElement checkBox1 = 		driver.findElement(By.xpath("(//*[@type=\"checkbox\"])[1]"));
		WebElement checkbox2  =     driver.findElement(By.xpath("(//*[@type=\"checkbox\"])[2]"));
		
		Assert.assertFalse(checkBox1.isSelected(), "Checkbox 1 should be unchecked!");
		
		Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 should be checked!");
		
		checkBox1.click();
		
		Assert.assertTrue(checkBox1.isSelected(), "Checkbox 1 should be checked after click!");
	}
	
	
	@Test(priority = 2, description = "Validate button enabled and disabled states")
	public void buttonEnabledTest() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		WebElement button = driver.findElement(By.xpath("//button[contains(text(), 'Enable')]"));
		WebElement inputBox = driver.findElement(By.xpath("//input[@type=\"text\"]"));
		
		
		Assert.assertFalse(inputBox.isEnabled(), "Input box should be disabled!");
		
		button.click();
		
		Thread.sleep(3000);
		
		
		Assert.assertTrue(inputBox.isEnabled(), "Input box should be enabled after clicking Enable!");
		
		
		
	}
	
	public void teardown() {
		driver.quit();
	}
	
	
	
	
	
	

}
