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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
        public void createServiceMessage() throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            loginUtil.Login();
            parentHandle();

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
            System.out.println("User tag is selected");

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

            WebElement Title=dropdown.findElement(By.xpath("//*[@id=\"newField_name\"]"));
            Title.sendKeys("Hello");
            System.out.println("Title is entered");

            WebElement value=driver.findElement(By.xpath("//*[@id=\"newField_value\"]"));
            value.sendKeys("How are you?");
            System.out.println("value is enetered");

            WebElement add= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[4]/div/div[5]/div/div[4]/div/div/div/div[2]/button"));
            add.click();
            System.out.println("Add button is clicked");

            WebElement actionTitle= driver.findElement(By.xpath("//*[@id=\"newButton_title\"]"));
            actionTitle.sendKeys("Hamro patro");
            System.out.println("Action title is entered");

            WebElement actionDeeplink=driver.findElement(By.xpath("//*[@id=\"newButton_url\"]"));
            actionDeeplink.sendKeys("https://www.hamropatro.com/");
            System.out.println("Action deeplink is entered");

            WebElement addAction= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[4]/div/div[6]/div/div[4]/div/div/div/div[2]/button"));
            addAction.click();
            System.out.println("Action add button is clicked");

            WebElement CreateButton= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]/form/div/div[5]/div/div/div/div/div/div/div/div[1]/button"));
            CreateButton.click();
            System.out.println("Create campaign button is Clicked");
            Thread.sleep(2000);

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement popoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"tooltip\"]")));
            WebElement confirmButton = popoverElement.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[2]"));
            confirmButton.click();
            System.out.println("Confirmed Yes");
            System.out.println("Service message is created successfully");
            Thread.sleep(5000);
        }
        @BeforeMethod
        @Parameters("browser")
        public void beforeMethod(String browser) throws InterruptedException {
            loginUtil= new LoginUtil(browser);
            driver= loginUtil.getDriver();
            createServiceMessage();
            Thread.sleep(3000);
        }
        @Test
        public void verifySm(){

            String expectedTarget="to deepen UT";
            String actualTarget= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]")).getText();
            Assert.assertEquals(actualTarget,expectedTarget,"Target doesnot match");
            System.out.println("Actual target: "+actualTarget);

            String expectedName="Automated SM";
            String actualName=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]")).getText();
            Assert.assertEquals(actualName,expectedName,"Campaign name does not match");
            System.out.println("Actula Name: "+actualName);

            String expectedCmpTitle="DRYHamro Gifts - This is a title";
            String actualCmpTitle=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[3]")).getText();
            Assert.assertEquals(actualCmpTitle,expectedCmpTitle,"Campaign Title does not macth");
            System.out.println("Actual campaign Title: "+actualCmpTitle);

            String expectedType="SM";
            String actualType= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[4]")).getText();
            Assert.assertEquals(actualType,expectedType,"Type does not match");
            System.out.println("Actual type: "+actualType);

            String expecctedExpireDate="Never";
            String actualExpectedDate=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[8]")).getText();
            Assert.assertEquals(actualExpectedDate,expecctedExpireDate,"Expired date does not match");
            System.out.println("Actual End date: "+actualExpectedDate);
        }
        @AfterMethod
        public  void tearDown(ITestResult result){
            src.takeScreenshotOnFailure(driver,result);
            driver.quit();
        }
    }