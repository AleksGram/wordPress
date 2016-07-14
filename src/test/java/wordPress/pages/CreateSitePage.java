package wordPress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import wordPress.Page;

import java.util.List;

/**
 * Created by Грам on 05.07.2016.
 */
public class CreateSitePage extends Page {
    @FindBy(css = ".card.survey-step__vertical.is-card-link")
   private List<WebElement> menuList;

    @FindBy(xpath = ".//button[1]")
   private WebElement backButton;

    public WebElement getBackButton() {
        return backButton;
    }

    @FindBy(css = "div.step-wrapper__buttons")

   private WebElement downBackButton;

    @FindBy(css = ".design-type__list")
    private WebElement designTypes;

    public WebElement getDownBackButton() {
        return downBackButton;
    }

    public WebElement getDesignTypes() {
        return designTypes;
    }




    public List<WebElement> getMenuList(){
        return menuList;
    }

    public void clickBackButton(){
        backButton.click();
    }

    public void clickDownBackButton(){
       /* Actions builder =new Actions(driver);
        builder.moveToElement(getDownBackButton()).click();
        Action clickToButton=builder.build();
        clickToButton.perform();*/
        downBackButton.click();
    }
}
