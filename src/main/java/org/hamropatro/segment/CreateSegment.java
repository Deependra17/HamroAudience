package org.hamropatro.segment;

import com.github.javafaker.Faker;
import org.hamropatro.util.LoginUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateSegment {
    WebDriver driver = new ChromeDriver();
    LoginUtil loginUtil = new LoginUtil(driver);
    Faker faker = new Faker();


    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }


    @Test(priority = 1, alwaysRun = true)
    public void NewSegment() {
        loginUtil.Login();
        parentHandle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Segment
        WebElement button = driver.findElement(By.id("rc-tabs-0-tab-segment"));
        button.click();
        System.out.println("Segment button is clicked");

        //create segment
        driver.findElement(By.xpath("//*[@id=\"rc-tabs-0-panel-segment\"]/div/div[1]/div/div/div/a")).click();
        System.out.println("This is a segment ");



        //Segment Name
        driver.findElement(By.id("name")).sendKeys(faker.address().city());
        System.out.println("Segment name has been Entered");

        //Add Button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/div[4]/div[4]/div/div/div/div/button")).click();
        System.out.println("Add button has been clicked");

        //CreateSegment
        driver.findElement(By.id("theme-btn")).click();
        System.out.println("Create segment button has been clicked");

    }


}


