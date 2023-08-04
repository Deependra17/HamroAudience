package org.hamropatro.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    public void takeScreenshotOnFailure(WebDriver webdriver, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot screenshot = (TakesScreenshot) webdriver;

            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(generateFilePath(result.getName()));
            try {
                FileUtils.copyFile(srcFile, destFile);
                System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private String generateFilePath(String testName) {
        String screenshotsDirectory = "/home/hamropatro/IdeaProjects/Audience/src/screenShots";
        String screenshotName = testName + ".png";
        return screenshotsDirectory + screenshotName;
    }
}
