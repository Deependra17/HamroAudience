package org.hamropatro.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static WebDriver driver;
    private DriverFactory(){
    }
    public static WebDriver build(String browser) {

        if (driver != null) return driver;

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options= new FirefoxOptions();
            options.setHeadless(true);

            driver = new FirefoxDriver(options);
        }
        return driver;
    }
}
