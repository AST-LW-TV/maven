package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

// page factory method
public class PageReference {
    public PageReference(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
