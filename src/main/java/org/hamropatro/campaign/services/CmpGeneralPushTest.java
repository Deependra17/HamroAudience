package org.hamropatro.campaign.services;

import org.hamropatro.util.CustomListener;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;

@Listeners(CustomListener.class)
public class CmpGeneralPushTest {
   private final WebDriver driver = new ChromeDriver();
    LoginUtil loginUtil = new LoginUtil(driver);
    ScreenShots src= new ScreenShots();
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    public void CreateGeneralPush() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();
        WebElement myElement = driver.findElement(By.id("theme-btn"));
        myElement.click();
      Thread.sleep(5000);
        System.out.println("Campaign button is clicked");
    }
    public void SelectTarget() throws InterruptedException {
       // use.SelectTarget();
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("segment")));
        dropdown.sendKeys("Ktm");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'ktm' is selected");
        Thread.sleep(3000);
    }
    public void ClickOnSchedule() {
        driver.findElement(By.id("scheduled")).click();
        System.out.println("Schedule button is clicked");

       // driver.findElement(By.id("isDryRun")).click();
    }
    public void NewsUrl() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"news-input-url\"]")).sendKeys("https://ekantipur.com/photo_feature/2023/06/21/168734626230329913.html");
        System.out.println("News url is entered");
        driver.findElement(By.id("scrapeNewsUrl")).click();
        Thread.sleep(5000);
        System.out.println("Scrape button is clicked");

        WebElement title=driver.findElement(By.id("title"));
        title.clear();
        title.sendKeys("This is a general push");

        driver.findElement(By.id("theme-btn")).click();
        System.out.println("Create campaign button is clicked");
        Thread.sleep(3000);
    }
    public void CreateCampaign(){
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popoverElement = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div/div[2]")));
        WebElement confirmButton = popoverElement.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]"));
        confirmButton.click();
        System.out.println("Confirmed Yes");
        System.out.println("General push is created successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void VerifyGeneralPush() throws InterruptedException {
        CreateGeneralPush();
        SelectTarget();
        ClickOnSchedule();
        NewsUrl();
        CreateCampaign();
        driver.manage().window().maximize();
        Thread.sleep(4000);

        String expectedTarget="Ktm";
        String actualTarget=driver.findElement(By.xpath("")).getText();




        driver.quit();
    }
}
