package org.hamropatro.usertag;

import com.github.javafaker.Faker;
import org.hamropatro.util.CustomListener;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class CreateUserTag {
    private final WebDriver driver = new ChromeDriver();
    LoginUtil loginUtil = new LoginUtil(driver);
    ScreenShots src= new ScreenShots();
    Faker faker = new Faker();

    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    @Test(alwaysRun = true)

    public void CreateNewSegment(){
        loginUtil.Login();
        parentHandle();
    }
}
