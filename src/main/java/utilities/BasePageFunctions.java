package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * this class represents the main functions of all pages
 *
 * @author Shlomi
 */


public abstract class BasePageFunctions {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // constructor
    public BasePageFunctions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // get webDriver
    public WebDriver getDriver() {
        return this.driver;
    }

    // navigate to URL
    public Boolean navigateToURL(String URL) {
        try {
            driver.navigate().to(URL);
            return true;
        } catch (Exception e) {
            System.out.println("Site was not loaded");
            return false;
        }
    }

    // get back webElement
    public WebElement getWebElement(By elem) {
        return getDriver().findElement(elem);
    }

    // click on element
    public Boolean clickOnElement(By elem) {
        try {
            getWebElement(elem).click();
            return true;
        } catch (Exception e) {
            System.out.println("Element " + elem + " was not clicked");
            return false;
        }
    }

    // clear field and then type text
    public Boolean clearAndTypeTextToElem(By elem, String text) {
        try {
            WebElement textField = getWebElement(elem);
            textField.clear();
            textField.sendKeys(text);
            return true;
        } catch (Exception e) {
            System.out.println("Element " + elem + " was not clear and text was not sent to");
            return false;
        }
    }

    // element to be clickable and click it
    public Boolean waitForElementToBeClickableAndClickIt(By elem) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elem)).click();
            return true;
        } catch (Exception e) {
            System.out.println("Wait for element to be clickable was not worked correct");
            return false;
        }
    }

    // wait for element to be visible
    public Boolean waitForElementToBeVisible(By elem) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
            return true;
        } catch (Exception e) {
            System.out.println("Wait for element to be visible was not worked correct");
            return false;
        }
    }

    // get attribute from element
    public String getElementAttribute(By elem, String attribute) {
        return getWebElement(elem).getAttribute(attribute);
    }

}
