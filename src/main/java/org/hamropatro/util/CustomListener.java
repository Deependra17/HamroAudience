package org.hamropatro.util;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;

public class CustomListener implements ITestListener{

    @Override
    public void onTestStart(ITestResult result) {
        // Executed before the start of each test method
        System.out.println("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Executed when a test method passes successfully
        System.out.println("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Executed when a test method fails
        System.out.println("Test failed");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Executed after the completion of the entire test run
        System.out.println("Test Finished");
    }
}
