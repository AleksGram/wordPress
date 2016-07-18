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

    public static LostPasswordPage getLostPasswordPage(){
        return new LostPasswordPage();
    }

    public static MobilePage getMobilePage(){
        return new MobilePage();
    }

    public static ForIosPage getForIosPage(){
        return new ForIosPage();
    }

    public static ForAndroidPage getForAndroidPage(){
        return new ForAndroidPage();
    }

}