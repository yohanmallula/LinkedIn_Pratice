package LinkedIn_Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadDownloadTest {
	
	WebDriver driver;
	String downloadPath  = System.getProperty("user.home") + "\\Downloads\\";
	
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Test(priority = 1, description = "Upload a file using sendKeys()")
	public void uploadFileTest() {
		 driver.get("https://the-internet.herokuapp.com/upload");

	        // file path in your system (change to your file path)
	        String filePath = System.getProperty("user.home") + "\\Desktop\\testfile.txt";

	        driver.findElement(By.id("file-upload")).sendKeys(filePath);
	        driver.findElement(By.id("file-submit")).click();

	        WebElement uploadedText = driver.findElement(By.id("uploaded-files"));
	        Assert.assertTrue(uploadedText.getText().contains("testfile.txt"),
	                "File upload failed!");
	}

}
