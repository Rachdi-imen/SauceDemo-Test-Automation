package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Functionality related to adding items to the shopping cart.
 */
public class AddToCartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By itemImgLink = By.id("item_4_title_link");
    private final By addToCartBtn = By.cssSelector(".btn_primary.btn_inventory");
    private final By removeBtn = By.cssSelector(".btn_secondary.btn_inventory");

    /**
     * Constructor for AddToCartPage class.
     *
     * @param driver The WebDriver instance to use.
     */
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Clicks on the item image link to navigate to the item page.
     */
    public void clickOnItemImg() {
        driver.findElement(itemImgLink).click();
    }

    /**
     * Waits for the item page to load and performs additional checks if needed.
     */
    public void checkItemPageDescription() {
        wait.until(ExpectedConditions.urlContains("/v1/inventory-item.html?id=4"));
        // Additional checks if needed
    }

    /**
     * Clicks on the Add to Cart button.
     * Verifies if the "REMOVE" button appears after clicking.
     */
    public void clickOnaddToCartBtn() {
        driver.findElement(addToCartBtn).click();
        // Wait for the Remove button to appear after clicking Add to Cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeBtn));

        // Verify immediately after click
        WebElement removeButton = driver.findElement(removeBtn);
        if (!(removeButton.isDisplayed() && removeButton.getText().trim().equalsIgnoreCase("REMOVE"))) {
            throw new IllegalStateException("Expected REMOVE button after adding to cart, but not found.");
        }
    }

    /**
     * Waits for the cart badge to update and confirms it contains one item.
     */
    public void checkCartContainsOneItem() {
        WebElement cartBadge = driver.findElement(By.cssSelector(".fa-layers-counter.shopping_cart_badge"));
        wait.until(ExpectedConditions.textToBePresentInElement(cartBadge, "1"));
    }

    /**
     * Clicks on the shopping cart icon to view the cart contents.
     */
    public void clickOnCartIcon() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }


    /**
     * Checks if the cart list page is displayed.
     *
     * @return true if the cart list page is displayed, false otherwise.
     */
    public boolean isCartListPageDisplayed() {
        return driver.getCurrentUrl().contains("cart.html");
    }
}
