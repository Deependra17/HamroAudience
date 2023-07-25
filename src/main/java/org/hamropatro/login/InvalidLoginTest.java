package org.hamropatro.login;

import org.hamropatro.util.CustomListener;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(CustomListener.class)
public class InvalidLoginTest {
    private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    @BeforeMethod
    @Parameters({"browser"})
    public  void beforeMethod(String browser){
        loginUtil = new LoginUtil(browser);
        driver = loginUtil.getDriver();
    }

    @Test()
    public void invalidTestLogin() throws InterruptedException {
        loginUtil.loginWithInvalidEmail();
        parentHandle();
        String expectedMessage = "Couldn't find your Google Account";
        String actualMessage = driver.findElement(By.xpath("")).getText();
        System.out.println("Actual result: "+actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatched");
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        src.takeScreenshotOnFailure(driver, result);
          driver.quit();
    }
}
