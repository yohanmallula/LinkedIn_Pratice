package LinkedIn_Pratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownHandlingTest {

	WebDriver driver;

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");

	}

	@Test
	public void handleSingleDropdown() {
		WebElement coursedropdown = driver.findElement(By.xpath("//*[@id=\"course\"]"));
		Select select = new Select(coursedropdown);
		select.selectByIndex(2);
		String aactualText = select.getFirstSelectedOption().getText();
		String exptedText = "Dot Net";
		Assert.assertEquals(aactualText, exptedText, "DropDown selection is missmatch");

	}

	@Test
	public void multabileselection() {
		WebElement multiselect = driver.findElement(By.xpath("//*[@id=\"ide\"]"));

		Select select = new Select(multiselect);

		Assert.assertTrue(select.isMultiple(), "is not mutable select");

		select.selectByIndex(2);
		select.selectByVisibleText("Eclipse");
		select.deselectByIndex(3);

		List<WebElement> mutabletext = select.getAllSelectedOptions();

		List<WebElement> mutableTextget = select.getOptions();

		for (WebElement getText : mutableTextget) {
			System.out.println(getText.getText());
		}

		for (WebElement options : mutabletext) {
			System.out.println(options.getText() + " ");
		}

	}

	public void tearDown() {
		driver.quit();
	}

}
