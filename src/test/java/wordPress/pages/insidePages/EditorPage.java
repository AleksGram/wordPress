package wordPress.pages.insidePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wordPress.Page;

/**
 * Created by User on 26.07.2016.
 */
public class EditorPage extends Page {
@FindBy (css = ".editor-title__input")
    private WebElement title;

    @FindBy(css = "#tinymce-1")
    private WebElement description;

    @FindBy(css = ".editor-ground-control__publish-button.is-primary")
    private WebElement publishButton;

    @FindBy(xpath = ".//*[@id='primary']//li[2]/a")
    private WebElement htmlButton;

    @FindBy(css = ".conf-alert_con")
    private WebElement deleteMessage;


    @FindBy(css = ".conf-alert_title")
    private WebElement reestablishedMessage;

    @FindBy(xpath = ".//div[1]/div/ul/li[3]")
    private WebElement inBasketBtn;

    @FindBy(css = ".post-controls__restore")
    private WebElement reestablishBtn;

    public WebElement getReestablishedMessage() {
        return reestablishedMessage;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getReestablishBtn() {
        return reestablishBtn;
    }

    public WebElement getInBasketBtn() {
        return inBasketBtn;
    }

    public WebElement getDeleteMessage() {
        return deleteMessage;
    }

    public WebElement getHtmlButton() {
        return htmlButton;
    }

    public void clickHtmlBtn(){
        htmlButton.click();
    }

    public void clickInBasketBtn(){
        inBasketBtn.click();
    }

    public void clickReestablishBtn(){
        reestablishBtn.click();
    }

    public WebElement getPublishButton() {
        return publishButton;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getPostTitle() {
        return title;
    }
}
