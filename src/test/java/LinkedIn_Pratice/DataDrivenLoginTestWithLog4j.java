package LinkedIn_Pratice;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataDrivenLoginTestWithLog4j {

	WebDriver driver;

	private static final Logger log = LogManager.getLogger(DataDrivenLoginTestWithLog4j.class);

	@BeforeClass
	public void setup() {
		log.info("==== lanching Browser== ");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		log.info("=== opened login page successfully==");

	}

	@Test(dataProvider = "loginData")
	public void loginTest(String username, String password, String expectedResult) {
		log.info("Navigating  to OrangeHRM Login Page");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		log.info("Entering username:  {}", username);
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);

		log.info("Entering username");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);

		log.info("Clicking Login button");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

		if (expectedResult.equals("Success")) {
			boolean inventoryPage = driver.getCurrentUrl().contains("inventory");
			log.info("Login success excepted .URL validate result: {}", inventoryPage);
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertTrue(inventoryPage, "Expected successful login but failed.");
		}
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		log.info("Providing test data @DataPropvider");
		return new Object[][] { { "standard_user", "secret_sauce", "Success" }

		};
	}
}
