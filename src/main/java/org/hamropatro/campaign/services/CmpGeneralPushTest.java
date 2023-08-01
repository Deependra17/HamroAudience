package org.hamropatro.campaign.services;

import org.hamropatro.repository.GeneralPush;
import org.hamropatro.util.*;
import org.openqa.selenium.*;
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
         GeneralPush locate= new GeneralPush();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();

        parentHandle();
        WebElement myElement = driver.findElement(By.id(locate.getClickOnCreateCampaign()));
        myElement.click();
        Thread.sleep(5000);
        System.out.println("Campaign button is clicked");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locate.getChooseTarget())));
        dropdown.sendKeys("This is a Automated Segment");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'ktm' is selected");
        Thread.sleep(3000);

        WebElement schedule= driver.findElement(By.id(locate.getClickOnSchedule()));
        schedule.click();
        System.out.println("Schedule button is clicked");

        WebElement dry= driver.findElement(By.id(locate.getCLickOnDryRun()));
        dry.click();
        System.out.println("Dry run is clicked");

        WebElement Title= driver.findElement(By.id(locate.getEnterTitle()));
        Title.sendKeys("This is a Automated GeneralPush");
        System.out.println("Title is entered");

        WebElement Description= driver.findElement(By.id(locate.getEnterDescription()));
        Description.sendKeys("Hello Everyone! ");
        System.out.println("Description is enterd");

        WebElement Deeplink= driver.findElement(By.id(locate.getEnterDeepLink()));
        Deeplink.sendKeys("hamropatro://app/news_browser/https://l.hamropatro.com");
        System.out.println("Deeplink is entered");

        WebElement CreateCampaign= driver.findElement(By.id(locate.getClickOnCreateCampaignButton()));
        CreateCampaign.click();
        System.out.println("Create campaign button is clicked");
        Thread.sleep(3000);

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popoverElement = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locate.getConfirmPopUp())));
        WebElement confirmButton = popoverElement.findElement(By.xpath(locate.getClickOnYes()));
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
        GeneralPush locate= new GeneralPush();
        String expectedTarget = "This is a Automated Segment SE";
        String actualTarget = driver.findElement(By.xpath(locate.getTargetName())).getText();
        System.out.println("Actual target :"+actualTarget);
        Assert.assertEquals(actualTarget,expectedTarget, "Campaign  target does not match");

        String expectedStatus = "DRY";
        String actualStatus = driver.findElement(By.xpath(locate.getStatus())).getText();
        System.out.println("Actual Status :"+actualStatus);
        Assert.assertEquals(actualStatus,expectedStatus, "Status does not match");

        String expectedTitle = "DRYThis is a Automated GeneralPush";
        WebElement element = driver.findElement(By.xpath( locate.getCampaignTitle()));
        String actualTitle = element.getText();
        System.out.println("Actual Title :"+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Campaign title does not match");

        String expectedType = "GP";
        String actualType = driver.findElement(By.xpath(locate.getCampaignType())).getText();
        Assert.assertEquals(actualType,expectedType, "Campaign type does not match");
        System.out.println("Actual Type :"+actualType);

        String expectedAuthor = "dbohara@hamropatro.com";
        String actualAuthor = driver.findElement(By.xpath(locate.getAuthor())).getText();
        Assert.assertEquals(actualAuthor,expectedAuthor, "Author name does not match");
        System.out.println("Actual Author :"+actualAuthor);
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}
