package wordPress.pages.insidePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wordPress.Page;

import java.util.List;

/**
 * Created by User on 23.07.2016.
 */
public class ArticlePage extends Page {

    @FindBy(css = ".like.sd-button")
    private WebElement likeButton;



    public WebElement getLikeButton() {
        return likeButton;
    }
}
