package org.hamropatro.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Set;

public class LoginUtil {
    private final WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public String getParentHandle() {
        return parentHandle;
    }

    private String parentHandle;

    public LoginUtil(String browser) {
        if (browser.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
    }
    public void Login() throws InterruptedException {
        Configuration config = new Configuration();
        Repository locate= new Repository();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config.getUrl());
        System.out.println("URL is Entered");

        this.parentHandle = driver.getWindowHandle();
        System.out.println("Parent window - " + parentHandle);

        driver.findElement(By.xpath(locate.getContinueWithGoogle())).click();
        System.out.println("Continue with google is clicked");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() <= 1) {
            System.out.println("No new windows found.");
            return;
        }
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to new window with handle: " + handle);
                System.out.println("User is on the new window");
            }
        }

        WebElement email= driver.findElement(By.xpath(locate.getEnterEmail()));
        email.sendKeys(config.getEmail());
        driver.findElement(By.xpath(locate.getClickEmailButton())).click();
        Thread.sleep(3000);
        System.out.println("Email is Entered Successfully");

        WebElement password= driver.findElement(By.xpath(locate.getEnterPassword()));
        password.sendKeys(config.getPassword());
        System.out.println("password is Entered successfully");

        driver.findElement(By.xpath(locate.getClickButton())).click();
        System.out.println("User logged in successfully");
    }
    public void loginWithInvalidEmail() throws InterruptedException {

        Configuration config2 = new Configuration();
        Repository repo2= new Repository();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config2.getUrl());
        System.out.println("URL is Entered");

        this.parentHandle = driver.getWindowHandle();
        System.out.println("Parent window - " + parentHandle);

        driver.findElement(By.xpath(repo2.getContinueWithGoogle())).click();
        System.out.println("Continue with google is clicked");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() <= 1) {
            System.out.println("No new windows found.");
            return;
        }
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to new window with handle: " + handle);
                System.out.println("User is on the new window");
            }
        }

        WebElement email= driver.findElement(By.xpath(repo2.getEnterEmail()));
        email.sendKeys(config2.getInvalidEmail());
        driver.findElement(By.xpath(repo2.getClickEmailButton())).click();
        Thread.sleep(3000);
        System.out.println("Email is Entered Successfully");
    }
    public  void loginWithInvalidPassword() throws InterruptedException {

        Configuration config3 = new Configuration();
        Repository repo3= new Repository();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config3.getUrl());
        System.out.println("URL is Entered");

        this.parentHandle = driver.getWindowHandle();
        System.out.println("Parent window - " + parentHandle);

        driver.findElement(By.xpath(repo3.getContinueWithGoogle())).click();
        System.out.println("Continue with google is clicked");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() <= 1) {
            System.out.println("No new windows found.");
            return;
        }
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to new window with handle: " + handle);
                System.out.println("User is on the new window");
            }
        }

        WebElement email= driver.findElement(By.xpath(repo3.getEnterEmail()));
        email.sendKeys(config3.getEmail());
        driver.findElement(By.xpath(repo3.getClickEmailButton())).click();
        Thread.sleep(3000);
        System.out.println("Email is Entered Successfully");

        WebElement password= driver.findElement(By.xpath(repo3.getEnterPassword()));
        password.sendKeys(config3.getInvalidPassword());
        System.out.println("password is Entered successfully");

        driver.findElement(By.xpath(repo3.getClickButton())).click();
        System.out.println("User logged in successfully");
    }
}

