package org.hamropatro.multishot.services;

import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ServiceMessageTest {
        private final WebDriver driver = new ChromeDriver();
        LoginUtil loginUtil = new LoginUtil(driver);
    ScreenShots src= new ScreenShots();
        public void parentHandle() {
            driver.switchTo().window(loginUtil.getParentHandle());
        }

        @Test(priority = 1, alwaysRun = true)
        public void CreateServiceMessage() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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