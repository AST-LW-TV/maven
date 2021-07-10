package unittests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import utils.BrowserSetup;

public class SearchStringValidationTest {
    private WebDriver driver;
    private GoogleHomePage googleHomePage;

    @BeforeClass
    public void preConditions() {
        driver = new BrowserSetup().browserInitialization();
        googleHomePage = new GoogleHomePage(driver);
    }

    @Test
    public void verifySearchString() {
        String string = googleHomePage.enterTheData();
        Assert.assertEquals("Testvagrant", string);
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
}
