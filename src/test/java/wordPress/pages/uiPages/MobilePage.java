package wordPress.pages.uiPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wordPress.Page;

/**
 * Created by Грам on 18.07.2016.
 */
public class MobilePage extends Page {
    @FindBy(css = ".button.button-ios")
    private WebElement iosButton;

    @FindBy (css = ".button.button-android")
    private WebElement androidButton;

    @FindBy (css = "#content")
    private WebElement contentForm;

    public WebElement getIosButton() {
        return iosButton;
    }

    public WebElement getContentForm() {
        return contentForm;
    }

    public WebElement getAndroidButton() {
        return androidButton;
    }

    public void clickAndroisButton(){
        androidButton.click();
    }

    public void clickIosButton(){
        iosButton.click();
    }
}
