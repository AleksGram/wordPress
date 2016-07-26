package wordPress.pages.insidePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wordPress.Page;

/**
 * Created by User on 26.07.2016.
 */
public class AdminWPPage extends Page {
@FindBy (css = ".masterbar__item-new")
    private WebElement createNewButton;



    public WebElement getCreateNewButton() {
        return createNewButton;
    }
}
