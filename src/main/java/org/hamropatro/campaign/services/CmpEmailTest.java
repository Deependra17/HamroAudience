package org.hamropatro.campaign.services;

import org.hamropatro.repository.Email;
import org.hamropatro.util.CustomListener;
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
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(CustomListener.class)
public class CmpEmailTest {
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

        WebElement myElement = driver.findElement(By.id(locate.getCreateButton()));
        myElement.click();
        System.out.println("Campaign button is clicked");

        driver.findElement(By.xpath(locate.getClickOnEmail())).click();
        System.out.println("Email is selected");
        Thread.sleep(4000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locate.getChooseUserList())));
        element.click();
        System.out.println("User list is selected");

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locate.getChooseAudience())));
        dropdown.sendKeys("To me");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'To me' is selected");
        Thread.sleep(3000);

        driver.findElement(By.xpath(locate.getCLickOnSchedule())).click();
        System.out.println("Schedule button is clicked");

        driver.findElement(By.xpath(locate.getEnterSubject())).sendKeys("Automated Email");
        System.out.println("Subject is entered");

        driver.findElement(By.xpath(locate.getClickOnLoadTemplate())).click();
        System.out.println("Load template button is clicked");
        Thread.sleep(3000);

        driver.findElement(By.xpath(locate.getLoadTemplate())).click();
        System.out.println("Template is loaded");
        Thread.sleep(3000);

        driver.findElement(By.xpath(locate.getClickOnCreateEmailCampaignButton())).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement popoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locate.getConfirmBox())));
        WebElement confirmButton = popoverElement.findElement(By.xpath(locate.getClickYes()));
        confirmButton.click();
        System.out.println("Confirmed Yes");
        System.out.println("Template email is created successfully");
    }
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) throws InterruptedException {
        loginUtil=  new LoginUtil(browser);
        driver = loginUtil.getDriver();
        createEmail();
        Thread.sleep(4000);
    }
    @Test
    public void verifyCmpEmail(){
        Email locate= new Email();

        String expectedTarget = "To me UL";
        String actualTarget = driver.findElement(By.xpath(locate.getCompareTargetAudience())).getText();
        System.out.println("Actual Target :"+actualTarget);
        Assert.assertEquals(actualTarget,expectedTarget, "Campaign  target does not match");

        String expectedTitle = "Automated Email";
        WebElement element = driver.findElement(By.xpath( locate.getCompareCampaignTitle()));
        String actualTitle = element.getText();
        System.out.println("Actual Title :"+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Campaign title does not match");

        String expectedType = "EMAIL";
        WebElement element1= driver.findElement(By.xpath(locate.getCompareEmailCampaignType()));
        String actualType =element1.getText();
        Assert.assertEquals(actualType,expectedType, "Campaign type does not Match");
        System.out.println("Actual Type :"+actualType);

        String expectedAuthor = "dbohara@hamropatro.com";
        String actualAuthor = driver.findElement(By.xpath(locate.getCompareCampaignAuthor())).getText();
        Assert.assertEquals(actualAuthor,expectedAuthor, "Author name does not match");
        System.out.println("Actual Author :"+actualAuthor);
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}
