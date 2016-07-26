package wordPress.pages.uiPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import wordPress.Page;

/**
 * Created by Грам on 18.07.2016.
 */
public class ForAndroidPage extends Page {
    @FindBy(css = ".gb_Sb")
    private WebElement androidFavicon;

    @FindBy(xpath = ".//*[@id='body-content']/div//div[1]//div[3]/div/div[1]/span//button")
    private WebElement andrDownloadButton;

    public WebElement getAndroidFavicon() {
        return androidFavicon;
    }

    public WebElement getAndrDownloadButton() {
        return andrDownloadButton;
    }
}
