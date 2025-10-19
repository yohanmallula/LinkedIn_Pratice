package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Widgets {
	
	public WebDriver driver;
	
	
	//constracter
	public Widgets(WebDriver driver  ) {
		this.driver = driver;
	}
	
	By widget = By.xpath("//*[text() = 'Widgets']");
	
	By Accordion = By.xpath("//*[text() = ' Accordion ']");
	
	By Accordion1    = By.xpath("//*[text() = 'Collapsible Group 1 - Readability']");
	
	By Accordion4 = By.xpath("//*[text() = 'Collapsible Group 4 - Cross Browser Testing']");
	
	By Accordion3 = By.xpath("//*[text() = 'Collapsible Group 3 - Methhod Chaining']");
	
	By Accordion2 = By.xpath("//*[text() = 'Collapsible Group 2 - Single Line Coding']");
	
	By close4 = By.xpath("//*[text() = 'Collapsible Group 1 - Readability']");
	
	By Widget2 = By.xpath("//*[text() = 'Widgets']");
	
	By slider = By.xpath("//*[text() = ' Slider ']");
	
	By sliderpoint = By.xpath("//*[@id=\"slider\"]/a");
	
	public void widget() {
		WebElement Widgets = driver.findElement(widget);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(Widgets).perform();
	}
	
	public void Accordion() {
		driver.findElement(Accordion).click();
	}
	
	public void Accordion1() {
		driver.findElement(Accordion1).click();
	}
	
	public void Accordion4() {
		driver.findElement(Accordion4).click();
	}
	
	public void Accordion3() {
		driver.findElement(Accordion3).click();
	}
	
	public void Accordion2() {
		driver.findElement(Accordion2).click();
	}
	
	public void close4() {
		driver.findElement(close4).click();
	}
	
	public void widget2() {
		WebElement Wiget = driver.findElement(Widget2);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(Wiget).perform();
	}
	
	public void slider() {
		driver.findElement(slider).click();
	}
	
	public void sliderpoint() {
		WebElement Sliderpoints =   driver.findElement(sliderpoint);
		Actions action = new  Actions(driver);	
		action.clickAndHold(Sliderpoints).moveByOffset(1000, 0).release().perform();

	}

}
