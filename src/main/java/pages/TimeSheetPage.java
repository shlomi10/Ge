package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageFunctions;

/**
 * this class represents the main page
 *
 * @author Shlomi
 */

public class TimeSheetPage extends BasePageFunctions {

    // constructor
    public TimeSheetPage(WebDriver driver) {
        super(driver);
    }

    By chatIcon = By.cssSelector(".oxd-icon.bi-chat-dots-fill");
    By cancelBTN = By.cssSelector(".oxd-form-actions .oxd-button.oxd-button--medium.oxd-button--ghost");
    By commentsArea = By.xpath("//textarea[@placeholder='Comment here']");

    // click on chat
    public Boolean clickOnChat() {
        return waitForElementToBeClickableAndClickIt(chatIcon);
    }

    // wait for cancel button
    public Boolean waitForCancelBTN() {
        return waitForElementToBeVisible(cancelBTN);
    }

    // get text from elem
    public String getTextFromTextBox(){
        return getElementAttribute(commentsArea, "value");
    }

}

