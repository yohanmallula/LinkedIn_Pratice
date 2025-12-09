package LinkedIn_Pratice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenLinkImageTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/broken_images");

	}

	@Test(priority = 1, description = "Validate broken images on page")
	public void checkBrokenImages() throws MalformedURLException, IOException {

		List<WebElement> images = driver.findElements(By.tagName("img"));

		int brokenImageCount = 0;

		for (WebElement img : images) {
			String src = img.getAttribute("src");

			if (src == null || src.isEmpty()) {
				brokenImageCount++;
				continue;
			}

			HttpURLConnection connection = (HttpURLConnection) (new URL(src)).openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			if (connection.getResponseCode() != 200) {
				System.out.print("Broken Image: " + src);
				brokenImageCount++;

			}
		}

		System.out.println("Total Broken Images: " + brokenImageCount);

	}
	
    @Test(priority = 2, description = "Validate broken links on page")
	public void checkBrokenLinks() throws MalformedURLException, IOException {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		int brokenLinks = 0;

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			if (url == null || url.isEmpty()) {
				brokenLinks++;
				continue;
			}

			HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.setRequestMethod("GET");
			huc.connect();

			int status = huc.getResponseCode();

			if (status >= 400) {
				System.out.println("Broken Link: " + url + " → Status: " + status);
				brokenLinks++;
			}

		}
		System.out.println("Total Broken Links: " + brokenLinks);

	}
    
    
    @AfterClass
	public void tearDown() {
		driver.quit();
	}

}
