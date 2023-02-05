package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import java.io.InputStream;
import java.util.Properties;

/**
 * this class represents the test runner
 *
 * @author Shlomi
 */

public class MainRunnerTest extends BaseTest {

    private String siteURL;
    Properties props;

    @BeforeMethod
    public void beforeMethod() {
        try {
            // load properties
            props = new Properties();

            String propFileName = "config.properties";
            // get the config properties file
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            props.load(inputStream);
            siteURL = props.getProperty("siteURL");
        } catch (Exception e) {
            System.out.println("There was problem load the properties file");
        }
    }

    @Test(priority = 1, description = "login test")
    public void loginToSystem() {
        Assert.assertTrue(loginPage.getWebSite(siteURL), "site was not loaded");
        loginPage.waitForLoginAppear();
        loginPage.enterUserName(props.getProperty("username"));
        loginPage.enterPassword(props.getProperty("password"));
        loginPage.clickLogin();
        mainPage.waitForTimeToLoad();
        timePage.clickOnRow();
        timeSheetPage.clickOnChat();
        timeSheetPage.waitForCancelBTN();
        System.out.println(timeSheetPage.getTextFromTextBox());
        Assert.assertEquals(timeSheetPage.getTextFromTextBox(), "Leadership Development", "Not the expected text at the comments");
    }

}
