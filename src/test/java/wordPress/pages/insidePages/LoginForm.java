package wordPress.pages.insidePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wordPress.Page;

/**
 * Created by Грам on 24.07.2016.
 */
public class LoginForm extends Page {

    @FindBy(id = "user_login")
    private WebElement loginfield;

    @FindBy(id = "user_pass")
    private WebElement passfield;

    @FindBy(id = "wp-submit")
    private WebElement submtButton;

    public WebElement getLoginfield() {
        return loginfield;
    }

    public WebElement getPassfield() {
        return passfield;
    }

    public WebElement getSubmtButton() {
        return submtButton;
    }

    public void typeLogin(String login) {
        loginfield.sendKeys(login);
    }

    public void typePasswd(String pass) {
        passfield.sendKeys(pass);
    }

    public void clickSubmtButton() {
        submtButton.click();
    }

}
