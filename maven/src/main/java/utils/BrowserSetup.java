package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class BrowserSetup {
    private String browser;
    private String mode;
    private String url;
    private WebDriver driver;

    // in development phase we give head mode
    // in production mode we give headless mode

//    mvn test
//    mvn verify
//    mvn failsafe:integration-test failsafe:verify

//    mvn -DbrowserFromCMD="chrome" test
//    mvn -DbrowserFromCMD="firefox" test

//    mvn -Dtest="PageNavigatedTest" -Dbrowser="chrome" test
//    mvn -Dtest="SearchStringValidationTest" -Dbrowser="chrome" test
//    mvn -Dtest="TextVerificationTest" -Dbrowser="chrome" test

//    mvn -Dtest="Integration1IT" verify
//    - runs that test and runs all the tests why ?

//    mvn help:active-profiles -> to see the active profiles
//    mvn -PdevelopmentPhase test
//    mvn -PdevelopmentPhase -Dtest=PageNavigatedTest test
//    mvn -PproductionPhase test

    // initializing the parameters
    public BrowserSetup() {
        browser = System.getProperty("browserFromCMD");
        url = "https://www.google.com";
        mode = "head";
        if (browser == null) {
            browser = GetTheDetails.getValue("browser");
            url = GetTheDetails.getValue("url");
            mode = GetTheDetails.getValue("mode");
        }
    }

    // returns the driver element
    public WebDriver browserInitialization() {
        boolean temp = browser.equalsIgnoreCase("chrome") ? true : false;
        (temp ? WebDriverManager.chromedriver() : WebDriverManager.firefoxdriver()).setup();
        if (temp) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--" + mode);
            driver = new ChromeDriver(options);
        } else {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--" + mode);
            driver = new FirefoxDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }
}
