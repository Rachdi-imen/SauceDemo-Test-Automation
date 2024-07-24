package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 *  Checkout process for a shopping cart.
 */
public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By checkoutBtn = By.cssSelector("a.btn_action.checkout_button[href='./checkout-step-one.html']");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueBtn = By.cssSelector("input.btn_primary.cart_button[value='CONTINUE']");
    private final By checkoutOverviewTitle = By.cssSelector(".subheader");

    /**
     * Constructor for CheckoutPage class.
     * @param driver The WebDriver instance to use.
     */
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Clicks on the Checkout button to proceed to checkout step one.
     */
    public void clickOnCheckoutBtn() {
        driver.findElement(checkoutBtn).click();
    }

    /**
     * Enters checkout information: first name, last name, and postal code.
     * @param firstName The first name to enter.
     * @param lastName The last name to enter.
     * @param postalCode The postal code to enter.
     */
    public void inputCheckoutInfo(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(postalCodeInput).sendKeys(postalCode);
    }

    /**
     * Clicks on the Continue button to proceed to checkout step two.
     */
    public void clickOnContinueBtn() {
        driver.findElement(continueBtn).click();
    }

    /**
     * Checks if the Checkout Overview page is displayed.
     * @return true if the Checkout Overview page is displayed, false otherwise.
     */
    public boolean isCheckoutOverviewPageDisplayed() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains("https://www.saucedemo.com/v1/checkout-step-two.html");
    }

    /**
     * Waits for the Checkout Overview page to be fully loaded and visible.
     */
    public void assertCheckoutOverviewPage() {
        wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/v1/checkout-step-two.html"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutOverviewTitle));
    }

    /**
     * Clicks on the Finish button to complete the checkout process.
     */
    public void clickOnFinishBtn() {
        driver.findElement(By.cssSelector(".btn_action.cart_button")).click();
    }

    /**
     * Waits for the Confirm Checkout page to be fully loaded and visible.
     */
    public void assertConfirmCheckoutPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".subheader")));
    }
}
