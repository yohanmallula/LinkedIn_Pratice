package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class producrs {
	
	public WebDriver driver;
	
	
	
	//Constracter
	public producrs( WebDriver driver) {
		this.driver = driver;
	}
	
	//By iteam = By.xpath("(//*[@data-product-id=\"1\"])[1]");
	
	By email = By.xpath("//*[@id=\"email\"]");
	
	By button = By.xpath("//*[@id=\"enterimg\"]");
	
	By firstname = By.xpath("//*[@placeholder=\"First Name\"]");
	
	By lastname = By.xpath("//*[@placeholder=\"Last Name\"]");
	
	By address = By.xpath("//*[@ng-model=\"Adress\"]");
	
	
	By emailaddres = By.xpath("//*[@type=\"email\"]");
	
	
	By phone = By.xpath("//*[@ng-model=\"Phone\"]");
	
	By Male = By.xpath("//*[@value=\"Male\"]");
	
	By Hobbies = By.xpath("//*[@id=\"checkbox1\"]");
	
	By movies = By.xpath("//*[text() = 'Movies ']");
	
	By language = By.xpath("//*[@id=\"msdd\"]");
	
	By Arbaic = By.xpath("//*[text() = 'Arabic']");
	
	By Skills = By.xpath("//*[@id=\"Skills\"]");
	
	
	By country = By.xpath("//*[@role=\"combobox\"]");
	
	By india = By.xpath("(//*[text() = 'India'])[2]");
	
	By year = By.xpath("//*[@id=\"yearbox\"]");
	
	By month = By.xpath("//*[@placeholder=\"Month\"]");
	
	By Day = By.xpath("//*[@placeholder=\"Day\"]");
	
	By password = By.xpath("//*[@id=\"firstpassword\"]");
	
	By cPassword = By.xpath("//*[@id=\"secondpassword\"]");
	
	
	By submit = By.xpath("id=\"submitbtn\"");
	
	
	//file upoload
	
	By upload = By.xpath("//*[@id=\"imagesrc\"]");
	
	public void email() {
		driver.findElement(email).sendKeys("yohanmallula8765@gmail.com");
	}
	

		public void button() {
			driver.findElement(button).click();
}
	
	
	public void firstname() {
		driver.findElement(firstname).sendKeys("yohan");
	}
	
	public void lastname() {
		driver.findElement(lastname).sendKeys("mallula");
	}
public void address() {
	driver.findElement(address).sendKeys("ksjfisjnglksdjghildjghndiljhdfgiljhjnfglkjhnfglokhj");
}


public void emailaddres() {
	driver.findElement(emailaddres).sendKeys("yohanmallula@gmail.com");
}
public void phone() {
	driver.findElement(phone).sendKeys("1234567891");
}


public void Male() {
	driver.findElement(Male).click();
}

public void Hobbies() {
	driver.findElement(Hobbies).click();
}

public void movies() {
	driver.findElement(movies).click();
}

public void language() {
	driver.findElement(language).click();
}

public void pagescrool() {
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	
	Object  totalHeight =  js.executeScript("return document.body.scrollHeight");
	 
	  js.executeScript("window.scrollTo(0, arguments[0] / 2);" , totalHeight);
}



public void Arbaic() {
	driver.findElement(Arbaic).click();
}


public void Skills() {
	WebElement Skill = driver.findElement(Skills);
	
	Select select = new Select(Skill);
	
	select.selectByIndex(2);
	
	List<WebElement> options = select.getOptions();
	
	
	//System.out.println(options.size());
	
 	for(WebElement option : options) {
		//System.out.println(option.getText());
	} 
	
	
}

public void getsourceCode() {
	
	String pageSource = driver.getPageSource();
	//System.out.println(pageSource);
	
}

public void country() {
	WebElement countrys = driver.findElement(country);
	countrys.click();
	
	driver.findElement(india).click();
}

public void year() {
	WebElement year1 = driver.findElement(year);
	
	Select select = new Select(year1);
	
	select.selectByIndex(4);
	
}

public void month() {
	
	WebElement months = driver.findElement(month);
	
	Select select = new Select(months);
	
	select.selectByIndex(5);
}

public void Day() {
	WebElement day1 = driver.findElement(Day);
	
	Select select = new Select(day1);
	
	select.selectByIndex(5);
}

public void password() {
	driver.findElement(password).sendKeys("12345678");
}

public void cPassword() {
	driver.findElement(cPassword).sendKeys("12345678");
}

public void submit1() {
	driver.findElement(submit).submit();
}

public void upoloadFile() {
	driver.findElement(upload).sendKeys("F:\\New folder\\yoahnTesting.txt");
}
}
