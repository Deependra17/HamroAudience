package org.hamropatro.util;

import org.hamropatro.segment.CreateSegment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public LoginUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void Login() {
        Configuration config = new Configuration();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config.getUrl());
        System.out.println("URL is Entered");

        this.parentHandle = driver.getWindowHandle();
        System.out.println("Parent window - " + parentHandle);

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/button")).click();
        System.out.println("Continue with google is clicked");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() <= 1) {
            System.out.println("No new windows found.");
            return; // No need to switch if there are no new windows
        }
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to new window with handle: " + handle);
                System.out.println("User is on the new window");
            }
        }

        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(config.getEmail());
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
        System.out.println("Email is Entered Successfully");

        driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys(config.getPassword());
        System.out.println("password is Entered successfully");

        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();
        System.out.println("User logged in successfully");

    }

}

