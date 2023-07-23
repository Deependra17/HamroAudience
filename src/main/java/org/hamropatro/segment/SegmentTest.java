package org.hamropatro.segment;

import org.hamropatro.util.CustomListener;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.time.Duration;

@Listeners(CustomListener.class)
public class SegmentTest {
    private WebDriver driver;
    private LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    public void createSegment() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginUtil.Login();
        parentHandle();

        WebElement button = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[3]"));
        button.click();
        System.out.println("Segment button is clicked");

        driver.findElement(By.xpath("//*[@id=\"rc-tabs-0-panel-segment\"]/div/div[1]/div/div/div/a")).click();
        System.out.println("This is a segment ");

        driver.findElement(By.id("name")).sendKeys("This is a Automated Segment");
        System.out.println("Segment name has been Entered");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/div[4]/div[4]/div/div/div/div/button")).click();
        System.out.println("Add button has been clicked");
        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"theme-btn\"]")).click();
        System.out.println("Create segment button has been clicked");
        Thread.sleep(3000);
        System.out.println("Segment is created successfully");
    }
    @BeforeMethod
    @Parameters("browser")
    public void BeforeMethod(String browser) throws InterruptedException {
        System.out.println("Browser: " + browser);
        loginUtil = new LoginUtil(browser);
        driver = loginUtil.getDriver();
        createSegment();
        Thread.sleep(4000);
    }
    @Test
    public void verifySegmentName() {
        String expectedName = "This is a Automated Segment";
        String actualName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/div/div/div/div/div/div/table/tbody/tr[2]/td[1]")).getText();
        System.out.println(actualName);
        Assert.assertEquals(actualName, expectedName, "Segment name does not match");

        String expectedAuthor="dbohara@hamropatro.com";
        String actualAuthor=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div[1]/div/div/div/div/div/div/table/tbody/tr[2]/td[4]")).getText();
        System.out.println(actualAuthor);
        Assert.assertEquals(actualAuthor,expectedAuthor,"Author does not match");
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }

}



