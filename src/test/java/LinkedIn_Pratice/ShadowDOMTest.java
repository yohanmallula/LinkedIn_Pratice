package LinkedIn_Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShadowDOMTest {
	
	
	WebDriver driver;
	
	
	
	 @BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://books-pwakit.appspot.com/");
	}
	
	@Test(description = "Handle Shadow DOM and search a book")
	public void shadowDomTest() {
		
		WebElement shadowHost = driver.findElement(By.tagName("book-app"));
		
		SearchContext shadowRoot  = shadowHost.getShadowRoot();
		
		  WebElement searchInput = shadowRoot.findElement(By.cssSelector("input#input"));
		  
		  searchInput.sendKeys("Selenium");
	}
	

	    public void tearDown() {
	        if (driver != null)
	            driver.quit();
	    }
	
	

}
