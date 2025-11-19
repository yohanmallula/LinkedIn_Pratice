package LinkedIn_Pratice;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsPracticeTest {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	private static final Logger log = LogManager.getLogger(ActionsPracticeTest.class);

	@BeforeClass(description = "Setup browser and utilities")
	public void setup() {
		log.info("==chromeDriver==");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		action = new Actions(driver);
	}

	@Test(priority = 1, description = "Hover over element and verify tooltip text")
	public void hoverAndTooltipTest() {

		log.info("Navigating to Tool Tips demo");
		driver.get("https://demoqa.com/tool-tips");

		WebElement hoverButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"toolTipButton\"]")));

		action.moveToElement(hoverButton).perform();

		WebElement tooltip = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tooltip-inner")));

		String tooltiptext = tooltip.getText();

		System.out.println(tooltiptext);

		Assert.assertTrue(tooltiptext.length() > 0, "ooltip should have text");

	}

	@Test(priority = 2, description = "Double click and verify message", dependsOnMethods = "hoverAndTooltipTest")
	public void doubleClickTest() {
		driver.get("https://demoqa.com/buttons");

		WebElement dblClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));
		action.doubleClick(dblClickBtn).perform();

		WebElement doubleClickMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));

		String msg = doubleClickMessage.getText();
		System.out.println(msg);

		Assert.assertTrue(msg.contains("You have done a double click"), "Double click confirmation missing");

	}

	@Test(priority = 3, description = "Right click (context click) and verify" , dependsOnMethods= "doubleClickTest")
		public void rightClickTest() {
			
			  WebElement rightClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("rightClickBtn")));
			  
			  action.contextClick(rightClickBtn).perform();
			  
			  WebElement rightClickMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage")));
			  
			  String msg = rightClickMsg.getText();
			  
			   Assert.assertTrue(rightClickMsg.getText().contains("You have done a right click"), "Right click confirmation missing");
			
		}

	public void tearDown() {
		driver.quit();
	}
}
