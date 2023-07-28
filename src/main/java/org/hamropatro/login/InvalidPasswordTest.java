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
public class InvalidPasswordTest {
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
    public void loginTestWithInvalidPassword() throws InterruptedException {
        loginUtil.loginWithInvalidPassword();
        parentHandle();
        String expectedMessage = "Wrong password. Try again or click Forgot password to reset it.";
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span")).getText();
        System.out.println("Actual result: "+actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match");
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }
}
