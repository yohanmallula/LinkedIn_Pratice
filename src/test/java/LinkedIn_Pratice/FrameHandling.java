
package LinkedIn_Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameHandling {

	WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Frames.html");
	}
	
	
	@Test(priority =1)
	public void handleSingleFrame() {
		driver.switchTo().frame("singleframe");
		WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
		input.sendKeys("heloo name");
		driver.switchTo().defaultContent();
		
	}
	
	@Test(priority =2)
	public void handleNestedFrames() {
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		WebElement outerframe = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outerframe);
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Nested Frame Test");
		
		driver.switchTo().defaultContent();
	}
	
	public void teardown() {
		driver.quit();
	}

}
