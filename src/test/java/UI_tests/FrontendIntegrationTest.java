package UI_tests;

import MainClass.MainTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class FrontendIntegrationTest extends MainTest {

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://localhost:3001");
    }

    @Test
    public void uploadFileAndGetAiResponse() {
//Document upload
        WebElement upload = driver.findElement(By.id("uploadInput"));
        upload.sendKeys("/path/to/sample.pdf");
//Query submission
        driver.findElement(By.id("queryInput")).sendKeys("Summarize this");
        driver.findElement(By.id("submitBtn")).click();
//AI response rendering
        String result = driver.findElement(By.id("responseBox")).getText();
        Assert.assertFalse(result.isEmpty());
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
