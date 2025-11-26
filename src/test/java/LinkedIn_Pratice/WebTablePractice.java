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

public class WebTablePractice {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/webtables");

	}

	@Test(priority = 1, description = "Count total rows and columns in the table")
	public void countRowsColumns() {
		List<WebElement> rows = driver.findElements(By.cssSelector(".rt-tr-group"));
		List<WebElement> columns = driver.findElements(By.cssSelector(".rt-resizable-header-content"));

		System.out.println("total rows " + rows.size());
		System.out.println("Total columns" + columns.size());
	}

	@Test(priority = 2, description = "Print all table data")
	public void printAllTableData() {
		List<WebElement> allRows = driver.findElements(By.cssSelector(".rt-tr-group"));

		System.out.println("Table Data");

		for (int i = 1; i <= allRows.size(); i++) {
			List<WebElement> cells = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[\" + i + \"]/div/div"));

			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}

			System.out.println();
		}
	}

	@Test(priority = 3, description = "Get data from specific cell")
	public void specificCellData() {
		WebElement cell = driver.findElement(By.xpath("//div[@class='rt-tbody']/div[1]/div/div[1]"));

		String value = cell.getText();

		System.out.println("\"Value from Row 1 Column 1: \" + value");
	}

	@Test(priority = 4, description = "Store all names in a List (Collections practice)")
	public void storeNamesInList() {
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@role='gridcell'][1]"));

		List<String> nameList = new ArrayList<>();

		for (WebElement n : names) {
			nameList.add(n.getText());
		}

		System.out.println("name List " + nameList);
	}

	public void tearDown() {
		driver.quit();
	}

}
