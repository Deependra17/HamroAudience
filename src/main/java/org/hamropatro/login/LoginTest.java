package org.hamropatro.login;

import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class LoginTest {
  public final WebDriver driver = new ChromeDriver();
   ChromeOptions options= new ChromeOptions();
    LoginUtil loginUtil = new LoginUtil(driver);
    ScreenShots src= new ScreenShots();

    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }

    @Test( alwaysRun = true)
    public void TestLogin() {
        options.addArguments("-no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        loginUtil.Login();
        parentHandle();
        String expectedTitle = "Hamro Audience";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Hamro Audience Failed!");
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
            src.takeScreenshotOnFailure(driver, result);
            driver.quit();
    }
}
