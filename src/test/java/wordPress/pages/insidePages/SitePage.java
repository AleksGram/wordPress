package wordPress.pages.insidePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wordPress.Page;

import java.util.List;

/**
 * Created by User on 23.07.2016.
 */
public class SitePage extends Page {
    @FindBy(css = "article h2 a")
   private List<WebElement> listOfArticles;


    public List<WebElement> getListOfArticles() {
        return listOfArticles;
    }


}
