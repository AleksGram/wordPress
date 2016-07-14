package wordPress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Грам on 02.07.2016.
 */
public class PagesOfTheSite {
    public static LoginPage getLoginPage() {
        return new LoginPage();
    }

    public static StartPage getStartPage () {
        return new StartPage();
    }

    public static CreateSitePage getCreateSitePage(){
        return new CreateSitePage();
    }

}