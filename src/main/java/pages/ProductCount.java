package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page object representing functionality related to product counts and names on a web page.
 */
public class ProductCount {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private static final By PRODUCT_ITEMS = By.cssSelector(".inventory_item");
    private static final By PRODUCT_NAMES = By.cssSelector(".inventory_item_name");

    /**
     * Constructor for ProductCount class.
     * @param driver The WebDriver instance to use.
     */
    public ProductCount(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Retrieves the number of products displayed on the page.
     * @return The count of products.
     */
    public int getProductCount() {
        List<WebElement> products = driver.findElements(PRODUCT_ITEMS);
        return products.size();
    }

    /**
     * Prints the names of all products displayed on the page.
     */
    public void printProductNames() {
        List<WebElement> productNames = driver.findElements(PRODUCT_NAMES);

        System.out.println("Liste des noms de produits :");
        for (WebElement productName : productNames) {
            System.out.println(productName.getText());
        }
    }
}
