package org.hamropatro.test;

import org.hamropatro.util.LoginUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class LoginTest {
    WebDriver driver = new ChromeDriver();
    LoginUtil loginUtil = new LoginUtil(driver);

    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }

    @Test(priority = 1)
    public void TestLogin() {
        loginUtil.Login();
        parentHandle();
        WebElement myElement = driver.findElement(By.id("theme-btn"));
        myElement.click();

    }
}
