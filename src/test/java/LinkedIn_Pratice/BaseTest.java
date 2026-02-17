package LinkedIn_Pratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
	
	protected WebDriver driver;
	
	//Normal method
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
	}
	
	public abstract void testExecution();
	
	
	
	

}
