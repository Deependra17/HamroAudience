package org.hamropatro.login;

import org.hamropatro.utils.CustomListener;
import org.hamropatro.utils.DriverFactory;
import org.hamropatro.utils.LoginUtil;
import org.hamropatro.utils.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(CustomListener.class)
public class InvalidEmailTest {
    private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    @BeforeMethod
    @Parameters({"browser"})
    public  void beforeMethod(String browser){
        driver = DriverFactory.build(browser);
        loginUtil= new LoginUtil(driver);
    }

    @Test()
    public void loginTestWithInvalidEmail() throws InterruptedException {
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
        //  driver.quit();
    }
}
