package org.hamropatro.segment;

import com.github.javafaker.Faker;
import org.hamropatro.util.CustomListener;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;


@Listeners(CustomListener.class)
public class SegmentTest {
   private final WebDriver driver = new ChromeDriver();
    LoginUtil loginUtil = new LoginUtil(driver);
    ScreenShots src= new ScreenShots();
    Faker faker = new Faker();

    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    @Test(priority = 1,alwaysRun = true)
    public void UserLogin(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("User is on the login.....");
        loginUtil.Login();
        parentHandle();
    }
    @Test(priority = 2,alwaysRun = true,dependsOnMethods = "UserLogin")
    public void ClickOnSegment(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[3]"));
        button.click();
        System.out.println("Segment button is clicked");
    }
    @Test(priority = 3,alwaysRun = true,dependsOnMethods="ClickOnSegment")
    public void ClickToCreateSegment() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"rc-tabs-0-panel-segment\"]/div/div[1]/div/div/div/a")).click();
        System.out.println("This is a segment ");
    }
    @Test(priority = 4, alwaysRun = true,dependsOnMethods = "ClickToCreateSegment")
    public void EnterSegmentName() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String randomName= faker.lorem().word();
        driver.findElement(By.id("name")).sendKeys(randomName);
        System.out.println(randomName);
        //driver.findElement(By.id("name")).sendKeys("AutomatedSegment");
        System.out.println("Segment name has been Entered");
        Thread.sleep(3000);
    }
    @Test(priority = 5,alwaysRun = true,dependsOnMethods = "EnterSegmentName")
    public void ClickOnAddButton() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/div[4]/div[4]/div/div/div/div/button")).click();
        System.out.println("Add button has been clicked");
        Thread.sleep(5000);
    }
    @Test(priority = 6,alwaysRun = true,dependsOnMethods = "ClickOnAddButton")
    public void ClickOnCreateSegment() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"theme-btn\"]")).click();
        System.out.println("Create segment button has been clicked");
        Thread.sleep(3000);
        driver.quit();
    }
//    @Test(priority = 7,alwaysRun = true,dependsOnMethods = "ClickOnCreateSegment")
//    public void VerifyCreatedSegment(){
//        String expectedSegmentName = "AutomatedSegment";
//        String actualSegmentname = driver.getTitle();
//        Assert.assertEquals(actualSegmentname, expectedSegmentName, "Segment name does not match.");
//    }

}



