package LinkedIn_Pratice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageFactoryLoginTest {

	WebDriver driver;
	private static final Logger log = LogManager.getLogger(PageFactoryLoginTest.class);
	Login_PageFactory loginPage;

	@BeforeClass
	public void setup() {
		log.info("Lunching browser");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");

		loginPage = PageFactory.initElements(driver, Login_PageFactory.class);

	}

	@Test(priority = 1)
	public void loginTest() {

		loginPage.login("standard_user", "secret_sauce");

		String actualTitle = driver.getTitle();
		System.out.println("Page title after login: {}" + actualTitle);

		Assert.assertTrue(actualTitle.contains("Swag Labs"), "Login failed - Title mismatch");
		log.info("Login successful!");

	}

	@Test(priority = 2, dependsOnMethods = "loginTest", description = "Validate menu items using Collections")
	public void validateMenuItems() {
		log.info("fetching menu items");

		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".bm-item-list a")));

		List<WebElement> menuItems = driver.findElements(By.cssSelector(".bm-item-list a"));

		List<String> itemsNames = new ArrayList<>();
		for (WebElement item : menuItems) {
			itemsNames.add(item.getText());
		}

		System.out.println("itemsNames" + itemsNames);
	}

}
