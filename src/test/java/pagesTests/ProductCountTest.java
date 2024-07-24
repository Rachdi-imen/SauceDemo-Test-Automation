package pagesTests;

import org.testng.annotations.Test;
import pages.ProductCount;
import setup.BaseTest;

public class ProductCountTest extends BaseTest {


    @Test
    public void productCountTest() {

        int numberOfProduct = new ProductCount(driver).getProductCount();
        System.out.println(numberOfProduct);
        new ProductCount(driver).printProductNames();

    }

}
