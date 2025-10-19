package LinkedIn_Pratice;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderr{
	WebDriver driver;	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/login");
	}
	@Test(dataProvider = "loginData")
	public void loginTest(String username , String password , String expectedMessage) {
		
			driver.findElement(By.id("userName")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login")).click();		
	}
	public void tearDown() {
		if(driver != null) {
			driver.quit();			
		}
	}	
	@DataProvider(name = "loginData")
	public Iterator<Object[]> providerData(){
		
		List<Object[]> data = new ArrayList<Object[]>();
		
		data.add(new Object[] {"testuser1", "wrongpass", "Invalid username or password!"});
		data.add(new Object[]{"testuser2", "Test@123", "Login Successful"});

		return data.iterator();
		};
	}
	
	
	
	
	
	
	
	
	
