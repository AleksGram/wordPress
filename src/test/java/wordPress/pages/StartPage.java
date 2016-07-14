package wordPress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;
import wordPress.Page;


/**
 * Sample pages
 */
public class StartPage extends Page {


    @FindBy(id = "top-create-website-button")
    private WebElement createSiteButton;


    @FindBy(css = ".click-wpcom-login")
    private WebElement signInButton;

    @FindBy(css = "#apps")
    private WebElement appsLink;

    @FindBy(css = "#themes")
    private WebElement themesLink;


    public WebElement getCreateSiteButton() {
        return createSiteButton;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }


    public WebElement getAppsLink() {

        return appsLink;
    }

    public WebElement getThemesLink() {
        return themesLink;
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public void clickCreateSiteButton() {
        createSiteButton.click();
    }

    public void clickAppsLink() {
        appsLink.click();
    }

    public void clickThemesLink() {
        themesLink.click();
    }

    public LoginPage goToLoginPage() {
        signInButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public CreateSitePage goToCreateSitePage() {

        createSiteButton.click();
        return PageFactory.initElements(driver, CreateSitePage.class);
    }

    public void moveTo(WebElement webelement) {
        wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(webelement));
        Actions builder = new Actions(driver);
        builder.moveToElement(webelement);
        Action moveToLink = builder.build();
        moveToLink.perform();

    }
}

