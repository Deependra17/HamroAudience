package org.hamropatro.login;

import org.hamropatro.utils.CustomListener;
import org.hamropatro.utils.DriverFactory;
import org.hamropatro.utils.LoginUtil;
import org.hamropatro.utils.ScreenShots;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(CustomListener.class)
public class LoginTest {
    private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src = new ScreenShots();

    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(String browser) {
        driver = DriverFactory.build(browser);
        loginUtil = new LoginUtil(driver);
    }

    @Test()
    public void testLogin() throws InterruptedException {
        loginUtil.Login();
        parentHandle();
        String expectedTitle = "Hamro Audience";
        String actualTitle = driver.getTitle();
        System.out.println("Actual result: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Hamro Audience Failed!");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}
