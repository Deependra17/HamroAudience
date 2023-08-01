package org.hamropatro.campaign.services;

import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.hamropatro.repository.ShortMessage;
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

public class CmpShortServiceMessageTest {
  private  WebDriver driver;
  private LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    public void createShortServiceMessage() throws InterruptedException {
        ShortMessage locate= new ShortMessage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();

        WebElement myElement = driver.findElement(By.id(locate.getClickCreateCampaign()));
        myElement.click();
        System.out.println("Campaign button is clicked");

        driver.findElement(By.xpath(locate.getClickOnSMS())).click();
        System.out.println("SMS is selected");
        Thread.sleep(4000);
        driver.findElement(By.xpath(locate.getSelectAudienceTarget())).click();
        System.out.println("target user list is selected");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath(locate.getSelectAudienceTarget())).click();
        System.out.println("User list selected");

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locate.getSelectUser())));
        dropdown.sendKeys("To me");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'To me' is selected");
        Thread.sleep(3000);

        driver.findElement(By.xpath(locate.getClickOnDryRun())).click();
        System.out.println("Dry run is true");

        driver.findElement(By.xpath(locate.getScheduleCampaign())).click();
        System.out.println("Scheduled button is clicked");

        driver.findElement(By.xpath(locate.getEnterText())).sendKeys("This is a Automated short service message");
        System.out.println("SMS input text is entered");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locate.getCreateSMSCampaign())));
        button.click();

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popoverElement = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locate.getGoTOConfirmPopUp())));
        WebElement confirm = popoverElement.findElement(By.xpath(locate.getClickOnYesButton()));
        confirm.click();
        System.out.println("Confirmed Yes");
        System.out.println("SMS is created successfully");
        Thread.sleep(3000);
    }
        @BeforeMethod
        @Parameters("browser")
        public void BeforeMethod(String browser) throws InterruptedException {
            loginUtil= new LoginUtil(browser);
            driver = loginUtil.getDriver();
            createShortServiceMessage();
            Thread.sleep(4000);
        }
        @Test
        public void verifySms(){
            ShortMessage verify= new ShortMessage();

            String expectedTarget = "To me UL";
            String actualTarget = driver.findElement(By.xpath(verify.getCompareTarget())).getText();
            System.out.println("Actual target :"+actualTarget);
            Assert.assertEquals(actualTarget,expectedTarget, "Campaign  target does not match");

            String expectedStatus = "DRY";
            String actualStatus = driver.findElement(By.xpath(verify.getCompareStatus())).getText();
            System.out.println("Actual Status :"+actualStatus);
            Assert.assertEquals(actualStatus,expectedStatus, "Status does not match");

            String expectedTitle = "DRYThis is a Automated short service message";
            WebElement element = driver.findElement(By.xpath( verify.getCompareTitle()));
            String actualTitle = element.getText();
            System.out.println("Actual Title :"+actualTitle);
            Assert.assertEquals(actualTitle, expectedTitle, "Campaign title does not match");

            String expectedType = "SMS";
            WebElement element1= driver.findElement(By.xpath(verify.getCompareCampaignType()));
            String actualType =element1.getText();
            Assert.assertEquals(actualType,expectedType, "Campaign type does not Match");
            System.out.println("Actual Type :"+actualType);

            String expectedAuthor = "dbohara@hamropatro.com";
            String actualAuthor = driver.findElement(By.xpath(verify.getCompareAuthor())).getText();
            Assert.assertEquals(actualAuthor,expectedAuthor, "Author name does not match");
            System.out.println("Actual Author :"+actualAuthor);
        }
        @AfterMethod
        public void tearDown(ITestResult result) {
            src.takeScreenshotOnFailure(driver, result);
            driver.quit();
    }
}
