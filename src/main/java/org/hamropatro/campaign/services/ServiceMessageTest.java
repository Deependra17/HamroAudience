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
public class ServiceMessageTest {
   private final WebDriver driver = new ChromeDriver();
    LoginUtil loginUtil = new LoginUtil(driver);
    ScreenShots src= new ScreenShots();
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    @Test(priority = 1,alwaysRun = true)
    public void CreateServiceMessage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();
        WebElement myElement = driver.findElement(By.id("theme-btn"));
        myElement.click();
        System.out.println("Campaign button is clicked");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[2]")).click();
        System.out.println("Service Message is selected");

        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[2]/div/div/div/div/div/div/label[2]/span[1]/input")).click();
        System.out.println("User list is selected");
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/span[1]/input")));
        dropdown.sendKeys("To me");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'To me' is selected");
        Thread.sleep(3000);

        WebElement scheduled = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[3]/div/div[2]/div[1]/div/div/div/div/div/label/span[1]/input"));
        scheduled.click();
        System.out.println("Schedule button is clicked");

        driver.findElement(By.id("subtitle")).sendKeys("This is a Subtitle");
        System.out.println("Subtitle is entered");

        WebElement title=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[5]/div/div[2]/div/div/div[2]/div[1]/div/input"));
        title.sendKeys("This is a Title");
        System.out.println("Title is entered");

        WebElement dropDown= driver.findElement(By.id("miniAppId"));
        dropDown.sendKeys("2");
        dropDown.sendKeys(Keys.ENTER);
        System.out.println("Mini App is selected");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebElement button=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[6]/div/div/div/div/div/div/div/div[1]/button"));
        button.click();
        System.out.println("Create campaign button is clicked");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div/div[2]/div")));
        WebElement confirmButton = popoverElement.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]"));
        confirmButton.click();
        System.out.println("Confirmed Yes");
        System.out.println("Service message is created");





       // driver.quit();
    }
}
