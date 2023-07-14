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
    public void CreateShortServiceMessage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();

        WebElement multishot = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div"));
        multishot.click();
        System.out.println("Multishot button is clicked");
        Thread.sleep(3000);

        WebElement myElement = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div/a/button"));
        myElement.click();

        WebElement sms=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/div/div[3]/div"));
        sms.click();
        System.out.println("Sms is choosed");
        Thread.sleep(3000);

        WebElement Target= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[2]/div/div/div/div/div/div/label[1]/span[1]/input"));
        Target.click();
        System.out.println("target is selected");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div/span[1]/input")));
        dropdown.sendKeys("To me");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'TO deepen' is selected");
        Thread.sleep(3000);

        WebElement dry= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[4]/div/div[1]/div[2]/div/div/div/div/div/label/span[1]/input"));
        dry.click();
        System.out.println("Dru run is clicked");

        WebElement cmpTitle= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[4]/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/input"));
        cmpTitle.sendKeys("This is a Automated SMS");
        System.out.println("Campaign title is entered");

        WebElement gap=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[4]/div/div[2]/div/div[5]/div[1]/div/div/div[2]/div/div/input"));
        gap.sendKeys("1");
        System.out.println("Daygap is entered");

        WebElement Text= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[6]/div/div/div[2]/div/div/textarea"));
        Text.sendKeys("Hello Deepen!");
        System.out.println("Text is entered");

        WebElement ConfirmButton=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[7]/div/div/div/div/div/div/div/div[1]/button"));
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
    public void BeforeMethod(String browser) throws InterruptedException {
        loginUtil= new LoginUtil(browser);
        driver = loginUtil.getDriver();
        CreateShortServiceMessage();
        Thread.sleep(3000);
    }
    @Test
    private void VerifySms() throws InterruptedException {

        String expectedTarget="To me UL";
        String actualTarget=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]")).getText();
        Assert.assertEquals(actualTarget,expectedTarget,"Target does not match");
        System.out.println("Actual target: "+actualTarget);

        String expectedCmpName="This is a Automated SMS";
        String actualCmpName=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]")).getText();
        Assert.assertEquals(actualCmpName,expectedCmpName,"Campaign Name doesnot match");
        System.out.println("Actual Campaign Name: "+actualCmpName);

        String expectedCmpTitle="DRYHello Deepen!";
        String actualCmpTitle=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[3]/div/div/div")).getText();
        Assert.assertEquals(actualCmpTitle,expectedCmpTitle,"Campaign Tiitle does not match");
        System.out.println("Actual Campaign Title: "+actualCmpTitle);

        String actualType="SMS";
        String expectedTpye=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[4]")).getText();
        Assert.assertEquals(actualType,expectedTpye,"Campaign Type does not match");
        System.out.println("Actual Tpye: "+actualType);

        String expcetedExpireDate="Never";
        String actualExpireDate=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[8]")).getText();
        Assert.assertEquals(actualExpireDate,expcetedExpireDate,"End Date does not match");
        System.out.println("Actual Expire date: "+actualExpireDate);
        Thread.sleep(2000);

    }
    @AfterMethod
    public void TearDown(ITestResult result){
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}