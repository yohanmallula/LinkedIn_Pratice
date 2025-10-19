package LinkedIn_Pratice;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtons {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/basic-controls.html");
    }

    @Test(priority = 1, description = "Select Male radio button and verify selection")
    public void selectMaleRadioButton() {
        WebElement maleRadio = driver.findElement(By.id("malerb"));

        if (!maleRadio.isSelected()) {
            maleRadio.click();
        }

        Assert.assertTrue(maleRadio.isSelected(), "Male radio button should be selected");
        System.out.println("Male radio button selected successfully");
    }

    @Test(priority = 2, description = "Select Female radio button dynamically from all options")
    public void handleAllRadioButtons() throws InterruptedException {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//*[@type='radio' and @name='gender']"));
        System.out.println("Radio button count: " + radioButtons.size());

        for (WebElement radio : radioButtons) {
            String value = radio.getAttribute("value");
            if (value.equalsIgnoreCase("Female")) {
                radio.click();
                Thread.sleep(500);
                Assert.assertTrue(radio.isSelected(), "Female radio button should be selected!");
                System.out.println(" Female radio button selected successfully");
                break;
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
