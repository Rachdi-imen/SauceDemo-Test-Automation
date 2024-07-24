package pagesTests;

import org.testng.annotations.Test;
import pages.Logout;
import setup.BaseTest;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest(){
        new Logout(driver).logout();
    }
}
