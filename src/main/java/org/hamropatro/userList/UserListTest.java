package org.hamropatro.userList;

import org.hamropatro.util.CustomListener;
import org.hamropatro.util.LoginUtil;
import org.hamropatro.util.ScreenShots;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class UserListTest {
        private WebDriver driver;
        LoginUtil loginUtil;
        ScreenShots src= new ScreenShots();

        public void parentHandle() {
            driver.switchTo().window(loginUtil.getParentHandle());
        }
        @Test(alwaysRun = true)
        @Parameters("browser")
        public void createUserList(String browser) throws InterruptedException {
            loginUtil= new LoginUtil(browser);
            loginUtil.Login();
            parentHandle();
        }
}
