package LinkedIn_Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameHandlingTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1, description = "Handle simple iFrame and verify text")
	public void iFrameTest() {
		driver.get("https://the-internet.herokuapp.com/iframe");

		driver.switchTo().frame("mce_0_ifr");

		WebElement editor = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
		String textInside = editor.getText();

		Assert.assertTrue(textInside.length() > 0, "iFrame text is empty!");

		driver.switchTo().defaultContent();
	}

	@Test(priority = 2, description = "Handle nested frames and extract text")
	public void nestedFramesTest() {
		driver.get("https://the-internet.herokuapp.com/nested_frames");

		driver.switchTo().frame("frame-top");

		driver.switchTo().frame("frame-left");

		String leftText = driver.findElement(By.tagName("body")).getText();
		System.out.println("LEFT Frame Text: " + leftText);

		Assert.assertTrue(leftText.contains("LEFT"));

		driver.switchTo().parentFrame();

		driver.switchTo().frame("frame-middle");

		String middleText = driver.findElement(By.id("content")).getText();
		System.out.println("MIDDLE Frame Text: " + middleText);

		Assert.assertTrue(middleText.contains("MIDDLE"));

		driver.switchTo().defaultContent();
	}

	public void tearDown() {
		driver.quit();
	}

}
