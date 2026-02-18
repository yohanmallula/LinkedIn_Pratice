package LinkedIn2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest implements TestActions {

    WebDriver driver;

    @Override
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Override
    public void closeBrowser() {
        //driver.quit();
    }

    @Test
    public void executeTest() {
        launchBrowser();
        login("standard_user", "secret_sauce");
        closeBrowser();
    }
}
