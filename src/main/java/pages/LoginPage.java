package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Login functionality
 */
public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By userNameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By assertSuccessLogin = By.className("product_label");
    private final By errorMsg = By.cssSelector("h3[data-test='error']");

    /**
     * Constructor for LoginPage class.
     * @param driver The WebDriver instance to use.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Performs login with the provided username and password.
     * After clicking the login button, waits until the URL contains "inventory.html".
     * @param username The username to enter into the username field.
     * @param pwd The password to enter into the password field.
     */
    public void login(String username, String pwd) {
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(pwd);
        driver.findElement(loginBtn).click();
        //wait.until(ExpectedConditions.urlContains("inventory.html"));
    }

    /**
     * Asserts successful login by returning the text of the element indicating success.
     * @return The text indicating successful login.
     */
    public String assertLogin() {
        return driver.findElement(assertSuccessLogin).getText();
    }

    /**
     * Checks for the presence of error message after invalid login attempt.
     * @return true if error message is displayed, false otherwise.
     */
    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    /**
     * Gets the text of the error message displayed.
     * @return The text of the error message.
     */
    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}
