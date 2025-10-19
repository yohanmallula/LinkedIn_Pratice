package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPage {
	
	public WebDriver driver;
	
	
	
	
	
	public LoginPage( WebDriver driver) {
		this.driver = driver;
	}

	
	By login = By.xpath("(//*[@class=\"nav navbar-nav\"]/child::li)[4]");
	
	
	By naame = By.xpath("//*[@name=\"name\"]");
	
	By email = By.xpath("//*[@data-qa=\"signup-email\"]");
	
	
	By signup = By.xpath("//*[text() = \"Signup\"]");
	
	By tittle_Radio = By.xpath("//*[@id=\"id_gender1\"]");
	
	By password = By.xpath("//*[@id=\"password\"]");
	
	By days = By.xpath("//*[@id=\"days\"]");
	
	By month = By.xpath("//*[@id=\"months\"]");
	
	By year = By.xpath("//*[@id=\"years\"]");

	
	By firstname = By.xpath("//*[@id=\"first_name\"]");
	
	
	By lastname = By.xpath("//*[@id=\"last_name\"]");
	
	
	By address = By.xpath("//*[@id=\"address1\"]");
	
	By state = By.xpath("//*[@id=\"state\"]");
	
	
	By city = By.xpath("//*[@id=\"city\"]");
	
	By pincode = By.xpath("//*[@id=\"zipcode\"]");
	
	By mobilenumber = By.xpath("//*[@id=\"mobile_number\"]");
	
	
	By submitbutton = By.xpath("//*[text() = \"Create Account\"]");
	
	By continues = By.xpath("//*[text()=\"Continue\"]");
	
	
	
	
	
	public void logins() {
		driver.findElement(login).click();
	}
	
	public void name() {
		driver.findElement(naame).sendKeys("yohan");
	}
	
	public void email() {
		driver.findElement(email).sendKeys("yohanmallula@gmail391.com");
	}
	
	public void signup() {
		driver.findElement(signup).submit();
	}
	
	public void tittle_Radio() {
		driver.findElement(tittle_Radio).click();
	}
	
	public void password() {
		driver.findElement(password).sendKeys("12345678");
	}
	
	public void days() {
		WebElement dropdowndays = driver.findElement(days);
		
		Select select = new Select(dropdowndays);
		
		select.selectByIndex(4);
	}
	
	public void month() {
		WebElement monthDrop = driver.findElement(month);
		
		Select select = new Select(monthDrop);
		
		select.selectByIndex(4);
	}
	
	public void year() {
		WebElement years = driver.findElement(year);
		Select select = new Select(years);
		select.selectByIndex(25);
	}
	
	public void firstname(){
		driver.findElement(firstname).sendKeys("mallula");
	}
	
	
	public void lastname() {
		driver.findElement(lastname).sendKeys("mallula");
	}
	
	public void address() {
		driver.findElement(address).sendKeys("hsdfkjhkgjjhdfghdfg");
	}
	
	
	public void state() {
		driver.findElement(state).sendKeys("andhrapradesh");
	}
	
	
	public void city() {
		driver.findElement(city).sendKeys("narasapur");
	}
	
	public void pincode() {
		driver.findElement(pincode).sendKeys("534280");
	}

	
	public void mobilenumber() {
		driver.findElement(mobilenumber).sendKeys("9603543183");
	}
	
	public void submitbutton() {
		driver.findElement(submitbutton).submit();
	}
	
	public void continues() {
		driver.findElement(continues).click();
	}
}
