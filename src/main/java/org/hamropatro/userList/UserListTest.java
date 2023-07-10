package org.hamropatro.userList;

import org.hamropatro.util.CustomListener;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class UserListTest {
        private final WebDriver driver = new ChromeDriver();
        LoginUtil loginUtil = new LoginUtil(driver);
        ScreenShots src= new ScreenShots();

        public void parentHandle() {
            driver.switchTo().window(loginUtil.getParentHandle());
        }
        @Test(alwaysRun = true)

        public void CreateUserList() throws InterruptedException {
            loginUtil.Login();
            parentHandle();
        }
}
