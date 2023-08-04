package org.hamropatro.segment;

import org.hamropatro.utils.CustomListener;
import org.hamropatro.utils.DriverFactory;
import org.hamropatro.utils.LoginUtil;
import org.hamropatro.utils.ScreenShots;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

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

        WebElement SegmentName=driver.findElement(By.id("name"));
        SegmentName.sendKeys("This is a Automated Segment");
        System.out.println("Segment name has been Entered");
        Thread.sleep(3000);

        WebElement AddButton=driver.findElement(with(By.tagName("button")).below(SegmentName));
        AddButton.click();
        System.out.println("Add button has been clicked");
        Thread.sleep(5000);

        WebElement CreateButton=driver.findElement(with(By.tagName("button")).below(AddButton));
        CreateButton.click();
        System.out.println("Create segment button has been clicked");
        Thread.sleep(3000);
        System.out.println("Segment is created successfully");
    }
    @BeforeMethod
    @Parameters("browser")
    public void BeforeMethod(String browser) throws InterruptedException {
        System.out.println("Browser: " + browser);
        driver = DriverFactory.build(browser);
        loginUtil= new LoginUtil(driver);
        createSegment();
        Thread.sleep(4000);
    }
    @Test
    public void verifySegmentName() {
        String expectedName = "This is a Automated Segment";
        String actualName = driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]")).getText();
        System.out.println(actualName);
        Assert.assertEquals(actualName, expectedName, "Segment name does not match");

        String expectedAuthor="dbohara@hamropatro.com";
        String actualAuthor=driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]")).getText();
        System.out.println(actualAuthor);
        Assert.assertEquals(actualAuthor,expectedAuthor,"Author does not match");
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        src.takeScreenshotOnFailure(driver, result);
        driver.quit();
    }

}



