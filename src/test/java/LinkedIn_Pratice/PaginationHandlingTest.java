package LinkedIn_Pratice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaginationHandlingTest {

	WebDriver driver;
	List<String> allNames = new ArrayList<>();
	
	
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://datatables.net/examples/basic_init/scroll_y.html");
	}

	public void paginationTest() throws InterruptedException {

		boolean nextExists = true;

		while (nextExists) {

			List<WebElement> namecells = driver
					.findElements(By.cssSelector("table.dataTable tbody tr td:nth-child(1)"));

			for (WebElement cell : namecells) {
				String name = cell.getText().trim();
				if (!name.isEmpty()) {
					allNames.add(name);
				}
			}

			WebElement nextBtn = driver.findElement(By.id("example_next"));

			if (nextBtn.getAttribute("class").contains("disabled")) {
				nextExists = false;
			} else {
				nextBtn.click();
				Thread.sleep(1000);
			}

		}
		  allNames.forEach(System.out::println);
	}
	
	public void tearDown() {
		driver.quit();
	}

}
