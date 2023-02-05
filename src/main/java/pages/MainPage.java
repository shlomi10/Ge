package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageFunctions;

/**
 * this class represents the main page
 *
 * @author Shlomi
 */

public class MainPage extends BasePageFunctions {

    // constructor
    public MainPage(WebDriver driver) {
        super(driver);
    }

    By time = By.xpath("//span[.='Time']");

    // wait for page to load
    public Boolean waitForTimeToLoad() {
        return waitForElementToBeClickableAndClickIt(time);
    }

}
