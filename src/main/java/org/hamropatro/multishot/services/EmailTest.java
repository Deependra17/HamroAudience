package org.hamropatro.multishot.services;

import org.hamropatro.multishotLocators.Email;
import org.hamropatro.utils.DriverFactory;
import org.hamropatro.utils.LoginUtil;
import org.hamropatro.utils.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;

public class EmailTest {
    private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();

    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    public void createEmail() throws InterruptedException {
        Email locate= new Email();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();

        driver.findElement(By.xpath(locate.getClickMultishot())).click();
        System.out.println("Multishot is clicked");

        WebElement button = driver.findElement(By.xpath(locate.getClickOnCampaign()));
       button.click();
        System.out.println("Campaign button is clicked");

        driver.findElement(By.xpath(locate.getClickOnEmailToCreateEmailCampaign())).click();
        System.out.println("Email is selected");
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locate.getChooseTargetAudience())));
        dropdown.sendKeys("Ktm");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'ktm' is selected");
        Thread.sleep(3000);

        WebElement dry= driver.findElement(By.xpath(locate.getClickDryRun()));
        dry.click();
        System.out.println("Dry run is true");

        WebElement title= driver.findElement(By.xpath(locate.getEnterEmailCampaignTitle()));
        title.sendKeys("This is a Automated Multishot Campaign");
        System.out.println("Campaign title is Entered");

        WebElement loacl= driver.findElement(By.xpath(locate.getSetLocalTIme()));
        loacl.click();
        System.out.println("Local time is set");

        WebElement gap= driver.findElement(By.xpath(locate.getSetDaysGap()));
        gap.sendKeys("1");
        System.out.println("Days gep is set");

        WebElement subject= driver.findElement(By.xpath(locate.getEnterCampaignSubject()));
        subject.sendKeys("Automated Email Campaign");
        System.out.println("Subject is entered");

        WebElement normal= driver.findElement(By.xpath(locate.getSelectEmailType()));
        normal.click();
        System.out.println("Normal Email is Selected");
        Thread.sleep(3000);

        WebElement text= driver.findElement(By.xpath(locate.getEnterEmailText()));
        text.sendKeys("This is a Normal Email");
        System.out.println("Normal Email text");

        WebElement Confirm= driver.findElement(By.xpath(locate.getClickOnCampaignCreateButton()));
        Confirm.click();
        System.out.println("Create button is clicked");
        Thread.sleep(3000);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement popoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locate.getFindConfirmBox())));
        WebElement confirmButton = popoverElement.findElement(By.xpath(locate.getClickToYes()));
        confirmButton.click();
        System.out.println("Confirmed Yes");
        System.out.println("Normal email is created successfully");
    }
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) throws InterruptedException {
        driver = DriverFactory.build(browser);
        loginUtil= new LoginUtil(driver);
        createEmail();
        Thread.sleep(3000);
    }
    @Test
    public void verifyEmail(){
        Email locate= new Email();

        String expectedTarget="Ktm SE";
        String actualTarget= driver.findElement(By.xpath(locate.getVerifyExpectedTarget())).getText();
        Assert.assertEquals(actualTarget,expectedTarget,"Target doesnot match");
        System.out.println("Actual target: "+actualTarget);

        String expectedName="This is a Automated Multishot Campaign";
        String actualName=driver.findElement(By.xpath(locate.getVerifyExpectedName())).getText();
        Assert.assertEquals(actualName,expectedName,"Campaign name does not match");
        System.out.println("Actula Name: "+actualName);

        String expectedCmpTitle="DRYAutomated Email Campaign";
        String actualCmpTitle=driver.findElement(By.xpath(locate.getVerifyExpectedTitle())).getText();
        Assert.assertEquals(actualCmpTitle,expectedCmpTitle,"Campaign Title does not macth");
        System.out.println("Actual campaign Title: "+actualCmpTitle);

        String expectedType="EMAIL";
        String actualType= driver.findElement(By.xpath(locate.getVerifyExpectedType())).getText();
        Assert.assertEquals(actualType,expectedType,"Type does not match");
        System.out.println("Actual type: "+actualType);

        String expecctedExpireDate="Never";
        String actualExpectedDate=driver.findElement(By.xpath(locate.getVerifyExpectedExpireDate())).getText();
        Assert.assertEquals(actualExpectedDate,expecctedExpireDate,"Expired date does not match");
        System.out.println("Actual End date: "+actualExpectedDate);
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}
