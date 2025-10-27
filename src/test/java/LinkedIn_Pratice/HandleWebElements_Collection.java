package LinkedIn_Pratice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleWebElements_Collection {

	WebDriver driver;

	private static final Logger log = Logger.getLogger(HandleWebElements_Collection.class);

	@BeforeClass
	public void setup() {
		log.info("launching Browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		// login steps
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).submit();
		log.info("HandleWebElements_Collection , Successfully logged ");

	}

	@Test
	public void extractProductName() throws InterruptedException {

		Thread.sleep(2000);

		List<WebElement> productElements = driver.findElements(By.xpath("//*[@class=\"inventory_item_name \"]"));
		ArrayList<String> productList = new ArrayList<>();

		for (WebElement product : productElements) {
			String name = product.getText();
			productList.add(name);
			log.info("product found ");
			System.out.println(name);
		}

		int ProductnameSize = productList.size();

		// remove the dublicate product name use set
		Set<String> uniqueProduct = new HashSet<>(productList);

		if (productList.size() == uniqueProduct.size()) {
			System.out.println("No duplicate products found!");
		} else {
			System.out.println("Duplicate products detected!");
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
