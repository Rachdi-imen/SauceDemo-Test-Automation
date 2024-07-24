package pagesTests;

import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.BaseTest;
import utils.CSVUtils;
import utils.DataInjectionIntern;


public class LoginPageTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(LoginPageTest.class.getName());

    @Test(priority = 1, dataProvider = "csvData", dataProviderClass = CSVUtils.class)
    public void testValidLogin(String userName, String password, String firstName, String lastName, String code) {

        logger.info("Starting valid login test for user: " + userName);
        LoginPage loginPage = new LoginPage(driver);

        // Perform valid login
        loginPage.login(userName, password);

        // Assertion for successful login
        String actualAssert = loginPage.assertLogin();
        String expectedAssert = "Products";
        Assert.assertEquals(actualAssert, expectedAssert, "Login assertion failed for user: " + userName);
        logger.info("Login successful for user: " + userName);

    }


   // @Test(priority = 2, dataProvider = "userData", dataProviderClass = DataInjectionIntern.class)
    public void testInvalidLoginEmptyUsername(String userName, String password) {

        logger.info("Starting invalid login test with empty username");
        LoginPage loginPage = new LoginPage(driver);

        // Perform invalid login with empty username
        loginPage.login(userName, password);

        // Assertion for error message
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty username login");

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required",
                "Incorrect error message ");

        logger.info("Error message displayed for empty username login");
    }

   // @Test(priority = 3, dataProvider = "userData", dataProviderClass = DataInjectionIntern.class)
    public void testInvalidLoginEmptyPassword(String userName, String password) {

        logger.info("Starting invalid login test with empty password");
        LoginPage loginPage = new LoginPage(driver);

        // Perform invalid login with empty password
        loginPage.login(userName, password);

        // Assertion for error message
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty password login");

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required",
                "Incorrect error message ");

        logger.info("Error message displayed for empty password login");
    }

    //@Test(priority = 4, dataProvider = "userData", dataProviderClass = DataInjectionIntern.class)
    public void testInvalidLoginLockedOutUser(String userName, String password) {

        logger.info("Starting invalid login test with locked out user");
        LoginPage loginPage = new LoginPage(driver);

        // Perform invalid login with locked out user
        loginPage.login(userName, password);

        // Assertion for specific error message
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for locked out user login");

        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service",
                "Incorrect error message");

        logger.info("Correct error message displayed for locked out user login");
    }
}
