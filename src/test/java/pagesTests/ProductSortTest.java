package pagesTests;

import pages.ProductSort;
import setup.BaseTest;

public class ProductSortTest extends BaseTest {


    public void  itemSortTest(){

        new ProductSort(driver).selectNameZtoA();

    }

}
