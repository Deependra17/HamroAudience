package org.hamropatro.multishot.services;

import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class EmailTest {
    private final WebDriver driver = new ChromeDriver();
    LoginUtil loginUtil = new LoginUtil(driver);
    ScreenShots src= new ScreenShots();

    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }

    @Test(alwaysRun = true)
    public void CreateEmail() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[2]")).click();
        System.out.println("Multishot is clicked");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"rc-tabs-0-panel-multishot\"]/div/div[1]/div[1]/div/div/a"));
       button.click();
        System.out.println("Campaign button is clicked");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[4]")).click();
        System.out.println("Email is selected");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[4]/div/form/div[2]/div[1]/div/div/div/div/div/div/label[3]/span[1]/input")));
        element.click();
        System.out.println("User Tag is selected");

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[4]/div/form/div[2]/div[1]/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/span[1]/input")));
        dropdown.sendKeys("To me");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'To me' is selected");
        Thread.sleep(3000);


        //driver.quit();
    }
}
