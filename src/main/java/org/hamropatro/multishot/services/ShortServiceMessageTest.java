package org.hamropatro.multishot.services;

import org.hamropatro.multishotLocators.ShortMessage;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.SortedMap;

public class ShortServiceMessageTest {
    private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();
    public void parentHandle(){
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    public void createShortServiceMessage() throws InterruptedException {
        ShortMessage locator=new ShortMessage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();

        WebElement multishot = driver.findElement(By.xpath(locator.getClickOnMultishotButton()));
        multishot.click();
        System.out.println("Multishot button is clicked");
        Thread.sleep(3000);

        WebElement myElement = driver.findElement(By.xpath(locator.getCLickToCampaignButton()));
        myElement.click();

        WebElement sms=driver.findElement(By.xpath(locator.getCLickOnSMS()));
        sms.click();
        System.out.println("Sms is choosed");
        Thread.sleep(3000);

        WebElement Target= driver.findElement(By.xpath(locator.getSelectTargetForSMS()));
        Target.click();
        System.out.println("target is selected");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getSelectUserAudienceForSMS())));
        dropdown.sendKeys("To me");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'TO deepen' is selected");
        Thread.sleep(3000);

        WebElement dry= driver.findElement(By.xpath(locator.getClickOnDRYRun()));
        dry.click();
        System.out.println("Dru run is clicked");

        WebElement cmpTitle= driver.findElement(By.xpath(locator.getEnterSMSCampaignTitle()));
        cmpTitle.sendKeys("This is a Automated SMS");
        System.out.println("Campaign title is entered");

        WebElement gap=driver.findElement(By.xpath(locator.getEnterDayGap()));
        gap.sendKeys("1");
        System.out.println("Daygap is entered");

        WebElement Text= driver.findElement(By.xpath(locator.getEnterSMSText()));
        Text.sendKeys("Hello Deepen!");
        System.out.println("Text is entered");

        WebElement ConfirmButton=driver.findElement(By.xpath(locator.getClickOnCreateSMsCampaignButton()));
        ConfirmButton.click();
        System.out.println("Create Campaign button is clicked");
        Thread.sleep(3000);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.getToConfirmationBox())));
        WebElement confirmButton = popoverElement.findElement(By.xpath(locator.getYesToCreateSMSCampaign()));
        confirmButton.click();
        System.out.println("Confirmed Yes");
        System.out.println("Service message is created successfully");
        Thread.sleep(5000);

    }
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) throws InterruptedException {
        loginUtil= new LoginUtil(browser);
        driver = loginUtil.getDriver();
        createShortServiceMessage();
        Thread.sleep(3000);
    }
    @Test
    private void verifySms() throws InterruptedException {
        ShortMessage locator=new ShortMessage();

        String expectedTarget="To me UL";
        String actualTarget=driver.findElement(By.xpath(locator.getCampaignTarget())).getText();
        Assert.assertEquals(actualTarget,expectedTarget,"Target does not match");
        System.out.println("Actual target: "+actualTarget);

        String expectedCmpName="This is a Automated SMS";
        String actualCmpName=driver.findElement(By.xpath(locator.getCampaignName())).getText();
        Assert.assertEquals(actualCmpName,expectedCmpName,"Campaign Name doesnot match");
        System.out.println("Actual Campaign Name: "+actualCmpName);

        String expectedCmpTitle="DRYHello Deepen!";
        String actualCmpTitle=driver.findElement(By.xpath(locator.getCampaignTitle())).getText();
        Assert.assertEquals(actualCmpTitle,expectedCmpTitle,"Campaign Tiitle does not match");
        System.out.println("Actual Campaign Title: "+actualCmpTitle);

        String actualType="SMS";
        String expectedTpye=driver.findElement(By.xpath(locator.getCampaignType())).getText();
        Assert.assertEquals(actualType,expectedTpye,"Campaign Type does not match");
        System.out.println("Actual Tpye: "+actualType);

        String expcetedExpireDate="Never";
        String actualExpireDate=driver.findElement(By.xpath(locator.getCampaignEndDate())).getText();
        Assert.assertEquals(actualExpireDate,expcetedExpireDate,"End Date does not match");
        System.out.println("Actual Expire date: "+actualExpireDate);
        Thread.sleep(2000);

    }
    @AfterMethod
    public void tearDown(ITestResult result){
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}