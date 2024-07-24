package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductSort {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By sortDropdown = By.className("product_sort_container");

    /**
     * Constructor for ProductSort class.
     *
     * @param driver The WebDriver instance to use.
     */
    public ProductSort(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Selects the sorting option "Name (Z to A)" from the dropdown.
     */
    public void selectNameZtoA() {
        selectOptionByValue("za");
    }

    /**
     * Selects the sorting option "Price (high to low)" from the dropdown.
     */
    public void selectPriceHighToLow() {
        selectOptionByValue("hilo");
    }

    /**
     * Selects the sorting option "Price (low to high)" from the dropdown.
     */
    public void selectPriceLowToHigh() {
        selectOptionByValue("lohi");
    }

    /**
     * Helper method to select an option from the dropdown by its value attribute.
     * @param value The value attribute of the option to select.
     */
    private void selectOptionByValue(String value) {
        WebElement dropdown = driver.findElement(sortDropdown);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    /**
     * Retrieves all options available in the sorting dropdown.
     * @return List of WebElements representing the options in the dropdown.
     */
    public List<WebElement> getAllOptions() {
        WebElement dropdown = driver.findElement(sortDropdown);
        Select select = new Select(dropdown);
        return select.getOptions();
    }
}
