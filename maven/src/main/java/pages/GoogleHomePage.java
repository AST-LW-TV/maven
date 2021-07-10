package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GetTheDetails;
import utils.PageReference;

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

    public WebElement gmailElement() {
        return gmailLink;
    }

    public WebElement imagesElement() {
        return imagesLink;
    }

    public WebElement inputElement() {
        return googleInputElement;
    }

    public String enterTheData() {
        String stringPassed = "Testvagrant";
        googleInputElement.sendKeys(stringPassed);
        return stringPassed;
    }

    public String currentTitle() {
        return driver.getTitle();
    }

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
