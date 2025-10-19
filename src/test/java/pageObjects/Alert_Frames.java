package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Alert_Frames {
	
	
	public WebDriver driver;
	
	//constracter
	public Alert_Frames(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By SwitchTo = By.xpath("//*[text() = 'SwitchTo']");
	
	By Alert = By.xpath("//*[text() = 'Alerts']");
	
	By Alert_With_OK = By.xpath("//*[@id=\"OKTab\"]");
	
	By OK_Cancel = By.xpath("//*[@class=\"active\"]/child::a");
	
	By Ok_Cancel2 = By.xpath("//*[@id=\"CancelTab\"]");
	
	By alert_Class_GetText = By.xpath("//*[@class=\"tabpane pullleft\"]");
	
	By alert_With_Text = By.xpath("//*[text() = 'Alert with Textbox ']");
	
	By alert3 = By.xpath("//*[@id=\"Textbox\"]");
	
	By gettext4 = By.xpath("//*[@id=\"demo1\"]");
	
	
	public void Switchto() {
		WebElement Switch = driver.findElement(SwitchTo);
		
		//Actions action = new Actions(driver);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(Switch).perform();
	}
	
	
	public void Alert() {
		driver.findElement(Alert).click();
	}
	
	public void Alert_With_OK() {
		driver.findElement(Alert_With_OK).click();
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		
	}
	
	public void OK_Cancel() {
		
		
		driver.findElement(OK_Cancel).click();
	}
	
	
	public void Ok_Cancel2() {
		driver.findElement(Ok_Cancel2).clear();
		driver.switchTo().alert().accept();
	}
	
	public void alert_Class_GetText() {
		String alerttext = driver.findElement(alert_Class_GetText).getText();
		
		System.out.println(alerttext);
	}
	
	
	public void alert_With_Text() {
		driver.findElement(alert_With_Text).click();
	}
	
	public void alert3() {
		driver.findElement(alert3).click();
		
		//String GetText1 = driver.switchTo().alert().getText();
		
		//System.out.println(GetText1);
		driver.switchTo().alert().accept();
	
		
	}
	
	public void alert4() {
		String GetAlertText = driver.findElement(gettext4).getText();
		
		String ExpartedText = "Hello Automation Testing user How are you today";
		
		System.out.println(GetAlertText);
		
		Assert.assertEquals(GetAlertText ,ExpartedText , "same ");
		
		System.out.println("done ");
		
		
	}
	
	

}
