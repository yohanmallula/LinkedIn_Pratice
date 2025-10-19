package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SummerNote {
	
	
	public WebDriver driver;
	
	
	//constracter
	public SummerNote(WebDriver driver) {
		this.driver = driver;
	}
	
	By SummaryNote1 = By.xpath("(//*[@class = \"dropdown-toggle\"])[6]");
	
	By SummaryNote2 = By.xpath("//*[text()=\"SummerNote\"]");
	
	By NoteWriting = By.xpath("//*[@class=\"note-editable panel-body\"]");
	
	By Bold_Text = By.xpath("//*[@class=\"note-icon-bold\"]");
	
	By Font_Style = By.xpath("//*[@data-original-title=\"Font Family\"]");
	
	By Font_Type = By.xpath("/html/body/section/div[1]/div/div/div[2]/div[2]/div[3]/div/div/li[3]/a/span");
	
	public void SummaryNote11() {
		WebElement SummaryNote11 = driver.findElement(SummaryNote1);
	
		Actions action = new Actions(driver);
		action.moveToElement(SummaryNote11).perform();

	}
	
	
	public void SummaryNote2() {
		 driver.findElement(SummaryNote2).click();
		
	}
	
	public void NoteWriting() {
		driver.findElement(NoteWriting).sendKeys("tesxt yohan mallula");
		driver.findElement(NoteWriting).clear();
		driver.findElement(NoteWriting).sendKeys("hamm 2nd time writing");
		driver.findElement(NoteWriting).sendKeys(Keys.CONTROL, "A");
		//driver.findElement(NoteWriting).sendKeys(Keys.CONTROL, "B");
	}
	public void CTRL_B() {
		driver.findElement(Bold_Text).click();
	}
	
	public void Font_Style() {
		driver.findElement(Font_Style).click();
		
		driver.findElement(Font_Type).click();
		
		//Select dropdown = new Select(Font_Style1);
		
		//dropdown.selectByIndex(2);
	}
	
	
	

}
