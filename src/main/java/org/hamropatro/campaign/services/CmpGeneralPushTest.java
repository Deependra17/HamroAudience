package org.hamropatro.campaign.services;

import org.hamropatro.util.CustomListener;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(CustomListener.class)
public class CmpGeneralPushTest {
   private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
     public void createGeneralPush() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();

        parentHandle();
        WebElement myElement = driver.findElement(By.id("theme-btn"));
        myElement.click();
        Thread.sleep(5000);
        System.out.println("Campaign button is clicked");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("segment")));
        dropdown.sendKeys("This is a Automated Segment");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'ktm' is selected");
        Thread.sleep(3000);

        WebElement schedule= driver.findElement(By.id("scheduled"));
        schedule.click();
        System.out.println("Schedule button is clicked");

        WebElement dry= driver.findElement(By.id("isDryRun"));
        dry.click();
        System.out.println("Dry run is clicked");

        WebElement Title= driver.findElement(By.id("title"));
        Title.sendKeys("This is a Automated GeneralPush");
        System.out.println("Title is entered");

        WebElement Description= driver.findElement(By.id("detailMessage"));
        Description.sendKeys("Hello Everyone! ");
        System.out.println("Description is enterd");

        WebElement Deeplink= driver.findElement(By.id("deeplink"));
        Deeplink.sendKeys("hamropatro://app/news_browser/https://l.hamropatro.com");
        System.out.println("Deeplink is entered");

        WebElement CreateCampaign= driver.findElement(By.id("theme-btn"));
        CreateCampaign.click();
        System.out.println("Create campaign button is clicked");
        Thread.sleep(3000);

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popoverElement = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div/div[2]")));
        WebElement confirmButton = popoverElement.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]"));
        confirmButton.click();
        System.out.println("Confirmed Yes");
        System.out.println("General push is created successfully");
        Thread.sleep(3000);
    }
    @BeforeMethod
    @Parameters("browser")
    private void beforeMethod(String browser) throws InterruptedException {
        loginUtil= new LoginUtil(browser);
        driver = loginUtil.getDriver();
        createGeneralPush();
        Thread.sleep(4000);
    }
    @Test
    public void verifyGeneralPush(){
        String expectedTarget = "This is a Automated Segment SE";
        String actualTarget = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]")).getText();
        System.out.println("Actual target :"+actualTarget);
        Assert.assertEquals(actualTarget,expectedTarget, "Campaign  target does not match");

        String expectedStatus = "DRY";
        String actualStatus = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/div/div/div/span")).getText();
        System.out.println("Actual Status :"+actualStatus);
        Assert.assertEquals(actualStatus,expectedStatus, "Status does not match");

        String expectedTitle = "DRYThis is a Automated GeneralPush";
        WebElement element = driver.findElement(By.xpath( "/html/body/div[1]/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/div/div/div"));
        String actualTitle = element.getText();
        System.out.println("Actual Title :"+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Campaign title does not match");

        String expectedType = "GP";
        String actualType = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[3]")).getText();
        Assert.assertEquals(actualType,expectedType, "Campaign type does not match");
        System.out.println("Actual Type :"+actualType);

        String expectedAuthor = "dbohara@hamropatro.com";
        String actualAuthor = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[10]")).getText();
        Assert.assertEquals(actualAuthor,expectedAuthor, "Author name does not match");
        System.out.println("Actual Author :"+actualAuthor);
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}
