package unittests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.GoogleHomePage;
import utils.BrowserSetup;


// unit test to check whether the link text matches the actual given string
public class TextVerificationTest {
    private WebDriver driver;
    private GoogleHomePage googleHomePage;

    @BeforeClass
    public void preConditions() {
        System.out.println("Unit Test started");
        driver = new BrowserSetup().browserInitialization();
        googleHomePage = new GoogleHomePage(driver);
    }

    @Test
    public void verifyGmailText() {
        String text = googleHomePage.gmailElement().getText();
        Assert.assertEquals("Gmail", text);
    }

    @Test
    public void verifyImagesText() {
        String text = googleHomePage.imagesElement().getText();
        Assert.assertEquals("Images", text);
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
        System.out.println("Unit Test Ended");
    }
}
