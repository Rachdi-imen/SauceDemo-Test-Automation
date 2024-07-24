package pagesTests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.ProductSort;
import setup.BaseTest;

public class AddToCartPageTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(AddToCartPageTest.class);

    @Test(priority = 2)
    public void testAddToCartWithSortByPrice() {
        logger.info("Starting testAddToCartWithSortByPrice...");

        // Initialize pages
        AddToCartPage addToCartPage = new AddToCartPage(driver);

        // Perform actions
        logger.info("Selecting product sort by price high to low...");
        new ProductSort(driver).selectPriceHighToLow();

        performAddToCartFlow(addToCartPage);

        logger.info("testAddToCartWithSortByPrice completed successfully.");
    }

    //@Test(priority = 3)
    public void addToCartItem() {
        logger.info("Starting addToCartItem...");

        // Initialize pages
        AddToCartPage addToCartPage = new AddToCartPage(driver);

        // Perform actions
        logger.info("Selecting product sort by price high to low...");
        new ProductSort(driver).selectPriceHighToLow();

        performAddToCartFlow(addToCartPage);

        logger.info("addToCartItem completed successfully.");
    }

    private void performAddToCartFlow(AddToCartPage addToCartPage) {
        addToCartPage.clickOnaddToCartBtn();
        addToCartPage.checkCartContainsOneItem();
        addToCartPage.clickOnCartIcon();

        // Assertion
        Assert.assertTrue(addToCartPage.isCartListPageDisplayed(), "Cart list page is not displayed");
    }
}
