package LinkedIn_Pratice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	
	
	WebDriver driver;
	
	@Parameters({"browser" , "url"})
	@BeforeClass(description = "setup browser and launch URL dynamicically")
	public void setup(String browser , String url) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	
    @Test(priority = 1, description = "Validate page title")
    public void validatePageTitle() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertTrue(title.length() > 0, "Title should not be empty");
    }

	
	
	
}
