package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GetTheDetails;
import utils.PageReference;

// Google home page - page object model
public class GoogleHomePage extends PageReference {
    private WebDriver driver;
    private String temp;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(linkText = "Gmail")
    WebElement gmailLink;

    @FindBy(linkText = "Images")
    WebElement imagesLink;

    @FindBy(xpath = "//input[@role='combobox']")
    WebElement googleInputElement;

    // returns the gmail link element
    public WebElement gmailElement() {
        return gmailLink;
    }

    // returns the images link element
    public WebElement imagesElement() {
        return imagesLink;
    }

    // returns the google search input element
    public WebElement inputElement() {
        return googleInputElement;
    }

    // enters the predefined string into the search field
    public String enterTheData() {
        String stringPassed = "Testvagrant";
        googleInputElement.sendKeys(stringPassed);
        return stringPassed;
    }

    // returns the current page title
    public String currentTitle() {
        return driver.getTitle();
    }

    // navigate to the next page and returns the title of that page
    public String navigateToOtherPage() {
        String browser;
        googleInputElement.sendKeys("Testvagrant" + Keys.ENTER);
        browser = System.getProperty("browserFromCMD");
        if (browser == null) {
            browser = GetTheDetails.getValue("browser");
        }
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.titleIs("Testvagrant - Google Search"));
            return driver.getTitle();
        }
        return driver.getTitle();
    }
}
