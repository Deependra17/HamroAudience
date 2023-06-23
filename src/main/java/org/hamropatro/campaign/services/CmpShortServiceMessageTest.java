package org.hamropatro.campaign.services;

import org.hamropatro.util.LoginUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class CmpShortServiceMessageTest {
  private final WebDriver driver = new ChromeDriver();
    LoginUtil loginUtil = new LoginUtil(driver);
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    @Test(priority = 1,alwaysRun = true)
    public void CreateShortServiceMessage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();

        WebElement myElement = driver.findElement(By.id("theme-btn"));
        myElement.click();
        System.out.println("Campaign button is clicked");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[3]")).click();
        System.out.println("SMS is selected");
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[2]/div/div/div/div/div/div/label[1]/span[1]/input")).click();
        System.out.println("target user list is selected");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div/span[1]/input")).click();
        System.out.println("User list selected");

        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div/span[1]/input")));
        dropdown.sendKeys("To me");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'To me' is selected");
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[4]/div/div[1]/div[2]/div/div/div/div/div/label/span[1]/input")).click();
        System.out.println("Dry run is true");

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[4]/div/div[2]/div[1]/div/div/div/div/div/label/span[1]/input")).click();
        System.out.println("Scheduled button is clicked");

        driver.findElement(By.xpath("//*[@id=\"text\"]")).sendKeys("This is a short service message");
        System.out.println("SMS input text is entered");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/form/div/div[7]/div/div/div/div/div/div/div/div[1]/button")));
        button.click();

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popoverElement = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div/div[2]/div")));
       // WebElement confirmButton = popoverElement.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]"));
        //confirmButton.click();
        System.out.println("Confirmed Yes");
        System.out.println("General push is created successfully");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
