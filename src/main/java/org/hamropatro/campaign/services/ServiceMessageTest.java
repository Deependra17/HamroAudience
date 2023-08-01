package org.hamropatro.campaign.services;

import org.hamropatro.util.CustomListener;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.Repository;
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
public class ServiceMessageTest {
   private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    public void createServiceMessage() throws InterruptedException {
        Repository locator= new Repository();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();
        WebElement myElement = driver.findElement(By.id(locator.getCreateCampaignButton()));
        myElement.click();
        System.out.println("Campaign button is clicked");

        driver.findElement(By.xpath(locator.getClickOnServiceMessage())).click();
        System.out.println("Service Message is selected");
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath(locator.getSelectTarget()));
        System.out.println("User list is selected");
        Thread.sleep(5000);

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.getSelectAudience())));
        dropdown.sendKeys("To me");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'To me' is selected");
        Thread.sleep(3000);

        WebElement scheduled = driver.findElement(By.xpath(locator.getClickOnScheduleSM()));
        scheduled.click();
        System.out.println("Schedule button is clicked");

        driver.findElement(By.xpath(locator.getCLickOnDryRunSM())).click();
        System.out.println("Dry run is clicked");

        driver.findElement(By.id(locator.getEnterSubTitle())).sendKeys("This is a Subtitle");
        System.out.println("Subtitle is entered");

        WebElement title=driver.findElement(By.xpath(locator.getEnterSmTitle()));
        title.sendKeys("This is a Title");
        System.out.println("Title is entered");

        WebElement dropDown= driver.findElement(By.id(locator.getChooseMiniApp()));
        dropDown.sendKeys("2");
        dropDown.sendKeys(Keys.ENTER);
        System.out.println("Mini App is selected");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement button=driver.findElement(By.xpath(locator.getCreateSmCampaign()));
        button.click();
        System.out.println("Create campaign button is clicked");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.getChooseConfirmBox())));
        WebElement confirmButton = popoverElement.findElement(By.xpath(locator.getClickOnSMYes()));
        confirmButton.click();
        System.out.println("Confirmed Yes");
        System.out.println("Service message is created successfully");
        Thread.sleep(5000);
    }
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) throws InterruptedException {
        loginUtil= new LoginUtil(browser);
        driver= loginUtil.getDriver();
        createServiceMessage();
        Thread.sleep(3000);
    }
    @Test
    public void verifyServiceMessage() {
        Repository locator= new Repository();
        String expectedTarget = "To me UL";
        String actualTarget = driver.findElement(By.xpath(locator.getConfirmTarget())).getText();
        System.out.println("Actual target :"+actualTarget);
        Assert.assertEquals(actualTarget, expectedTarget, "Campaign  target does not match");

        String expectedStatus = "DRY";
        String actualStatus = driver.findElement(By.xpath(locator.getConfirmStatus())).getText();
        System.out.println("Actual Status :"+actualStatus);
        Assert.assertEquals(actualStatus,expectedStatus, "Status does not match");

        String expectedTitle = "DRYHamro Gifts - This is a Title";
        WebElement element = driver.findElement(By.xpath( locator.getConfirmTitle()));
        String actualTitle = element.getText();
        System.out.println("Actual Title :"+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Campaign title does not match");

        String expectedType = "SM";
        String actualType = driver.findElement(By.xpath(locator.getConfirmServiceType())).getText();
        Assert.assertEquals(actualType,expectedType, "Campaign type does not match");
        System.out.println("Actual Type :"+actualType);

        String expectedAuthor = "dbohara@hamropatro.com";
        String actualAuthor = driver.findElement(By.xpath(locator.getConfirmAuthor())).getText();
        Assert.assertEquals(actualAuthor,expectedAuthor, "Author name does not match");
        System.out.println("Actual Author :"+actualAuthor);
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}
