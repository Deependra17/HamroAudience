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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ServiceMessageTest {
        private WebDriver driver;
        LoginUtil loginUtil;
    ScreenShots src= new ScreenShots();
        public void parentHandle() {
            driver.switchTo().window(loginUtil.getParentHandle());
        }
        @Test(priority = 1, alwaysRun = true)
        @Parameters("browser")
        public void CreateServiceMessage(String browser) throws InterruptedException {
            loginUtil= new LoginUtil(browser);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            loginUtil.Login();
            parentHandle();
            Thread.sleep(3000);

            WebElement multishot = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[1]/div/div[2]"));
            multishot.click();
            System.out.println("Multishot button is clicked");
            Thread.sleep(3000);
            WebElement myElement = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[1]/div/div/a/button"));
            myElement.click();

            WebElement Sm= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/div/div[2]/div"));
            Sm.click();
            System.out.println("Service Message is selected");
            Thread.sleep(4000);

            WebElement Ul= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[2]/div/div/div/div/div/div/label[3]/span[1]/input"));
            Ul.click();
            System.out.println("User List is selected");

            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[2]/div/div/div/div/div/div/div[3]/div/div/div/div/div/div/div/span[1]/input")));
            dropdown.sendKeys("To deepen");
            dropdown.sendKeys(Keys.ENTER);
            System.out.println("Option 'To deepen' is selected");
            Thread.sleep(3000);

            WebElement dry= dropdown.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[3]/div/div[1]/div[2]/div/div/div/div/div/label/span[1]/input"));
            dry.click();
            System.out.println("Dry run is active");

            WebElement CmpTitle= dropdown.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[3]/div/div[2]/div/div[1]/div/div/div/div[2]/div/div/input"));
            CmpTitle.sendKeys("Automated SM");
            System.out.println("Campaign title is entered");

            WebElement Localdelivery= dropdown.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[3]/div/div[2]/div/div[4]/div[2]/div/div/div[2]/div/div/label/span/input"));
            Localdelivery.click();
            System.out.println("Local Delivery is on");

            WebElement gap= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[3]/div/div[2]/div/div[5]/div[1]/div/div/div[2]/div/div/input"));
            gap.sendKeys("1");
            System.out.println("Days gap is entered");

            WebElement subtitle= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[4]/div/div[1]/div/div/div[2]/div/div/input"));
            subtitle.sendKeys("This is a subtitle");
            System.out.println("Subtitle is entered");

            WebElement title= dropdown.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[4]/div/div[2]/div/div/div[2]/div/div/input"));
            title.sendKeys("This is a title");
            System.out.println("Title is entered");

            WebElement dropDown= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[4]/div/div[4]/div[1]/div[2]/div/div/div[2]/div/div/div/div/span[1]/input"));
            dropDown.sendKeys("2");
            dropDown.sendKeys(Keys.ENTER);
            System.out.println("Mini App is selected");

            driver.quit();

        }
    }