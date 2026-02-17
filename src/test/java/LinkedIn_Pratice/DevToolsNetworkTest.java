package LinkedIn_Pratice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.DevTools;


public class DevToolsNetworkTest {
	
	
	WebDriver driver;
	DevTools devTools;
	
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//create DevTools session 
		devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		
	
			
	}

}
