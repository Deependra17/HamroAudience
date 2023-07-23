package org.hamropatro.login;

import org.hamropatro.util.CustomListener;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(CustomListener.class)
public class LoginTest {
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
    public void testLogin() throws InterruptedException {
        loginUtil.Login();
        parentHandle();
        String expectedTitle = "Hamro Audience";
        String actualTitle = driver.getTitle();
        System.out.println("Actual result: "+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Hamro Audience Failed!");
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
            src.takeScreenshotOnFailure(driver, result);
            driver.quit();
    }
}
