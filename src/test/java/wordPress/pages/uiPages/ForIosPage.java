package wordPress.pages.uiPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wordPress.Page;


public class ForIosPage extends Page {
    @FindBy(css = ".callout")
    private WebElement iosHeader;

    @FindBy(css = ".download>a+a>img")
    private WebElement iosDownloadButton;

    public WebElement getIosHeader() {
        return iosHeader;
    }

    public WebElement getIosDownloadButton() {
        return iosDownloadButton;
    }
}
