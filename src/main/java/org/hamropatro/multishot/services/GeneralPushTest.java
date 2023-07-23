package org.hamropatro.multishot.services;

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
import java.time.Duration;

public class GeneralPushTest {
    private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    public void createGeneralPush() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();

        WebElement multishot=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[2]"));
        multishot.click();
        System.out.println("Multishot button is clicked");

        WebElement myElement = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div/a/button"));
        myElement.click();
        Thread.sleep(4000);

        WebElement radioButton= driver.findElement(By.xpath("//*[@id=\"targetMode\"]/label[2]/span[1]/input"));
        radioButton.click();
        System.out.println("User list is selected");
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div[1]/form/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/span[1]/input")));
        dropdown.sendKeys("To me");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'TO deepen' is selected");
        Thread.sleep(3000);

        WebElement Dry= dropdown.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div[1]/form/div/div[3]/div/div[1]/div[2]/div/div/div/div/div/label/span[1]/input"));
        Dry.click();
        System.out.println("Dry run is active");

        WebElement CmpTitle= dropdown.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div[1]/form/div/div[3]/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/input"));
        CmpTitle.sendKeys("Automated General Push");
        System.out.println("Campaign title is entered");

        WebElement localTime= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div[1]/form/div/div[3]/div/div[2]/div/div[4]/div[2]/div/div/div[2]/div/div/label/span/input"));
        localTime.click();
        System.out.println("Local time is selected");

        WebElement gap= dropdown.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div[1]/form/div/div[3]/div/div[2]/div/div[5]/div[1]/div/div/div[2]/div/div/input"));
        gap.sendKeys("1");
        System.out.println("Day gap is 1 day");
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div[1]/form/div/div[4]/div/div[2]"));

        WebElement Title= driver.findElement(By.xpath("//*[@id=\"title\"]"));
        Title.sendKeys("This is a title");
        System.out.println("Title is Entered");

        WebElement description= driver.findElement(By.xpath("//*[@id=\"detailMessage\"]"));
        description.sendKeys("This is a automated general push from hamro patro");
        System.out.println("Description is entered");

        WebElement deepLink= driver.findElement(By.xpath("//*[@id=\"deeplink\"]"));
        deepLink.sendKeys("https://www.hamropatro.com/");
        System.out.println("Deeplink is entered");

        WebElement ConfirmButton=driver.findElement(By.xpath("//*[@id=\"theme-btn\"]"));
        ConfirmButton.click();
        System.out.println("Create Campaign button is clicked");
        Thread.sleep(3000);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"tooltip\"]")));
        WebElement confirmButton = popoverElement.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]"));
        confirmButton.click();
        System.out.println("Confirmed Yes");
        System.out.println("Service message is created successfully");
        Thread.sleep(5000);
    }
    @BeforeMethod
    @Parameters("browser")
    public void beforeMeethod(String browser) throws InterruptedException {
        loginUtil= new LoginUtil(browser);
        driver= loginUtil.getDriver();
        createGeneralPush();
        Thread.sleep(5000);
    }
    @Test
    public void verifyPush(){

        String expectedTarget="To me UL";
        String actualTarget= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]")).getText();
        Assert.assertEquals(actualTarget,expectedTarget,"Target doesnot match");
        System.out.println("Actual target: "+actualTarget);

        String expectedName="Automated General Push";
        String actualName=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]")).getText();
        Assert.assertEquals(actualName,expectedName,"Campaign name does not match");
        System.out.println("Actula Name: "+actualName);

        String expectedCmpTitle="DRYThis is a title";
        String actualCmpTitle=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[3]/div/div/div")).getText();
        Assert.assertEquals(actualCmpTitle,expectedCmpTitle,"Campaign Title does not macth");
        System.out.println("Actual campaign Title: "+actualCmpTitle);

        String expectedType="GP";
        String actualType= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[4]")).getText();
        Assert.assertEquals(actualType,expectedType,"Type does not match");
        System.out.println("Actual type: "+actualType);

        String expecctedExpireDate="Never";
        String actualExpectedDate=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[8]")).getText();
        Assert.assertEquals(actualExpectedDate,expecctedExpireDate,"Expired date does not match");
        System.out.println("Actual End date: "+actualExpectedDate);
    }
    @AfterMethod
    public void TearDown(ITestResult result){
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}