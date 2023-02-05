package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageFunctions;

/**
 * this class represents the main page
 *
 * @author Shlomi
 */

public class TimePage extends BasePageFunctions {

    // constructor
    public TimePage(WebDriver driver) {
        super(driver);
    }

    By viewOfSecondLine = By.xpath("//div[contains(@class,'row') and contains(.,'2022-08-15 - 2022-08-21')]//button");

    // click row
    public Boolean clickOnRow() {
        return waitForElementToBeClickableAndClickIt(viewOfSecondLine);
    }

}
