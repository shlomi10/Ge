package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BasePageFunctions;

/**
 * this class represents the login page
 *
 * @author Shlomi
 */

public class LoginPage extends BasePageFunctions {

    // constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By userNameField = By.xpath("//input[@name='username']");
    By passwordField = By.xpath("//input[@name='password']");
    By loginBTN = By.xpath("//button[@type='submit']");

    // navigate to the site
    public Boolean getWebSite(String site) {
        return navigateToURL(site);
    }

    // enter username
    public Boolean enterUserName(String userName) {
        return clearAndTypeTextToElem(userNameField, userName);
    }

    // enter password
    public Boolean enterPassword(String password) {
        return clearAndTypeTextToElem(passwordField, password);
    }

    // click login
    public Boolean clickLogin() {
        return clickOnElement(loginBTN);
    }

    // wait for login to appear
    public Boolean waitForLoginAppear() {
        return waitForElementToBeVisible(loginBTN);
    }

}
