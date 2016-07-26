package wordPress.pages.uiPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import wordPress.Page;

/**
 * Created by Грам on 17.07.2016.
 */
public class LostPasswordPage extends Page {
    @FindBy(css = "#user_login")
    private WebElement emailField;

    @FindBy(css = "#lostpasswordform")
    WebElement lostPasswdForm;



    @FindBy(css = "#wp-submit")
    private WebElement getNewPasswdButton;

    public WebElement getLostPasswdForm() {
        return lostPasswdForm;
    }

    public LostPasswordPage(){
    }
    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getGetNewPasswdButton() {
        return getNewPasswdButton;
    }
}

