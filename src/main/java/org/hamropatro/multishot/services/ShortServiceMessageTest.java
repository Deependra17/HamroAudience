package org.hamropatro.multishot.services;

import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShortServiceMessageTest {
    private WebDriver driver;
    LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }

    @Test(priority = 1, alwaysRun = true)
    @Parameters("browser")
    public void CreateShortServiceMessage(String browser) throws InterruptedException {
        loginUtil= new LoginUtil(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        loginUtil.Login();
        parentHandle();
        Thread.sleep(3000);

        WebElement multishot = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[2]"));
        multishot.click();
        System.out.println("Multishot button is clicked");
        Thread.sleep(3000);

        WebElement myElement = driver.findElement(By.id("theme-btn"));
        myElement.click();
        driver.quit();
    }
}