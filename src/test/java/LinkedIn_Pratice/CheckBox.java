package LinkedIn_Pratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBox {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
	}

	@Test(priority = 1)
	public void haandlesSingleCheckBox() {
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"englishchbx\"]"));

		if (!checkbox.isSelected()) {
			checkbox.click();
		}

		Assert.assertTrue(checkbox.isSelected(), "check is selected");
		System.out.println(" checkbox selected successfully");
	}

	@Test
	public void handleMutableCheckBox() {

		List<WebElement> MulatbleCheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement checkbox : MulatbleCheckBox) {
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}

		System.out.println("All checkboxes selected successfully");

	}

}
