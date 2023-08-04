package org.hamropatro.userTag;

import org.hamropatro.utils.CustomListener;
import org.hamropatro.utils.DriverFactory;
import org.hamropatro.utils.LoginUtil;
import org.hamropatro.utils.ScreenShots;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class UserTagTest {
    private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();

    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    @Test(alwaysRun = true)
    @Parameters("browser")
    public void createUserTag(String browser) throws InterruptedException {
        driver = DriverFactory.build(browser);
        loginUtil= new LoginUtil(driver);
        loginUtil.Login();
        parentHandle();
    }
}
