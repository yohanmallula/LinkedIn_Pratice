package LinkedIn_Pratice;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleSimpleAlertTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test(priority = 1)
    public void handleSimpleAlert() {
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Simple Alert Text: " + alert.getText());
        alert.accept();
    }

    @Test(priority = 2)
    public void handleConfirmAlert() {
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println("Confirm Alert Text: " + alert.getText());
        alert.dismiss();
    }

    @Test(priority = 3)
    public void handlePromptAlert() {
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        String name = "Yohan";
        alert.sendKeys(name);
        System.out.println("Entered text in Prompt Alert: " + name);
        alert.accept();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
