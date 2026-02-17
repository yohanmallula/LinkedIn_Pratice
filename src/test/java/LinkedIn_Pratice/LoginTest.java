package LinkedIn_Pratice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	
	@Test
	public void testExecution() {
		
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		String tittle = driver.getTitle();
		
		Assert.assertTrue(tittle.contains("Swag Labs"), "Login Failed!");
		
	}

}
