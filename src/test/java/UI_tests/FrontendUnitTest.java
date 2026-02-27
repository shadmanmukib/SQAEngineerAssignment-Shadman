package UI_tests;

import MainClass.MainTest;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FrontendUnitTest extends MainTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:3001");
    }
//Form Validation
    @Test
    public void validateEmptyInputShowsErrorMessage() {
        driver.findElement(By.id("submitBtn")).click();
        String error = driver.findElement(By.id("error")).getText();
        Assert.assertTrue(error.contains("required"));
    }
//Input sanitization
    @Test
    public void sanitizeXSSInput() {
        WebElement queryBox = driver.findElement(By.id("queryInput"));
        queryBox.sendKeys("<script>alert('xss')</script>");
        driver.findElement(By.id("submitBtn")).click();
//Response rendering
        String response = driver.findElement(By.id("responseBox")).getText();
        Assert.assertFalse(response.contains("<script>"));
    }
    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
