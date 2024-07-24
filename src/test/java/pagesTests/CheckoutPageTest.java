package pagesTests;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import setup.BaseTest;
import utils.CSVUtils;

public class CheckoutPageTest extends BaseTest {
    private static final Logger logger = Logger.getLogger(CheckoutPageTest.class.getName());

    @Test(priority = 3, dataProvider = "csvData", dataProviderClass = CSVUtils.class)
    public void testCheckoutProcess(String userName, String password, String firstName, String lastName, String code) {
        logger.info("Starting checkout process test");

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Click on Checkout button
        checkoutPage.clickOnCheckoutBtn();
        logger.info("Clicked on Checkout button.");

        // Input checkout information
        checkoutPage.inputCheckoutInfo(firstName, lastName, code);
        logger.info("Entered checkout information");

        // Click on Continue button
        checkoutPage.clickOnContinueBtn();
        logger.info("Clicked on Continue button.");

        // Assertion: Check if Checkout Overview page is displayed
        Assert.assertTrue(checkoutPage.isCheckoutOverviewPageDisplayed(), "Checkout overview page is not displayed");
        logger.info("Verified Checkout Overview page is displayed.");

        // Assert Checkout Overview page
        checkoutPage.assertCheckoutOverviewPage();
        logger.info("Asserted Checkout Overview page.");

        // Click on Finish button
        checkoutPage.clickOnFinishBtn();
        logger.info("Clicked on Finish button.");

        // Assert Confirm Checkout page
        checkoutPage.assertConfirmCheckoutPage();
        logger.info("Asserted Confirm Checkout page.");

        logger.info("Checkout process test completed successfully");
    }
}
