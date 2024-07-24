package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Logout functionality for the application.
 */


public class Logout {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By sidebarMenu = By.className("bm-burger-button");
    private final By logoutSidebarLink = By.id("logout_sidebar_link");

    /**
     * Constructor for Logout class.
     * @param driver The WebDriver instance to use.
     */
    public Logout(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Logs out from the application by clicking on the sidebar menu and then the logout link.
     * After logout, waits until the URL contains "index.html".
     */
    public void logout() {
        // Click on sidebar menu to open it
        driver.findElement(sidebarMenu).click();

        // Click on logout link in sidebar
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutSidebarLink)).click();

        // Wait until the URL contains "index.html" after logout
        wait.until(ExpectedConditions.urlContains("index.html"));
    }
}
