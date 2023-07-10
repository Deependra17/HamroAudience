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
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[4]/div/form/div[2]/div[1]/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div/span[1]/input")));
        dropdown.sendKeys("Ktm");
        dropdown.sendKeys(Keys.ENTER);
        System.out.println("Option 'ktm' is selected");
        Thread.sleep(3000);

        WebElement dry= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[4]/div/form/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div/div/label/span[1]/input"));
        dry.click();
        System.out.println("Dry run is true");

        WebElement title= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[4]/div/form/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/input"));
        title.sendKeys("This is a Automated Multishot Campaign");
        System.out.println("Camoaign title is Entered");

        WebElement loacl= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[4]/div/form/div[2]/div[2]/div/div[2]/div/div[4]/div[2]/div/div/div[2]/div/div/label/span/input"));
        loacl.click();
        System.out.println("Local time is set");

        WebElement gap= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[4]/div/form/div[2]/div[2]/div/div[2]/div/div[5]/div[1]/div/div/div[2]/div/div/input"));
        gap.sendKeys("1");
        System.out.println("Days gep is set");

        WebElement subject= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[4]/div/form/div[2]/div[3]/div/div/div[2]/div/div/input"));
        subject.sendKeys("Automated Email Campaign");
        System.out.println("Subject is entered");

        WebElement normal= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[4]/div/form/div[2]/div[5]/div[1]/div[1]/div/div[2]/div"));
        normal.click();
        System.out.println("Normal Email is Selected");
        Thread.sleep(3000);

        WebElement text= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[4]/div/form/div[2]/div[5]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div"));
        text.sendKeys("This is a Normal Email");
        System.out.println("Normal Email text");

        WebElement Confirm= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[4]/div/form/div[4]/div/div/div/div[1]/button"));
        Confirm.click();
        System.out.println("Create button is clicked");

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement popoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div")));
        WebElement confirmButton = popoverElement.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[2]"));
        confirmButton.click();
        System.out.println("Confirmed Yes");
        System.out.println("Normal email is created successfully");

        driver.quit();
    }
}
