package wordPress.pages.insidePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wordPress.Page;

/**
 * Created by Грам on 27.07.2016.
 */
public class AdminPanelPage extends Page {
@FindBy(css = ".posts")
    private WebElement showPostsItem;

    @FindBy(css = ".post-controls__trash :nth-child(1)")
     private WebElement deletePostBtn;

    @FindBy(css = ".masterbar__item")
    private WebElement mySiteBtn;

    public WebElement getMySiteBtn() {
        return mySiteBtn;
    }

    public WebElement getDeletePostBtn() {
        return deletePostBtn;
    }

    public WebElement getShowPostsItem() {
        return showPostsItem;
    }
}
