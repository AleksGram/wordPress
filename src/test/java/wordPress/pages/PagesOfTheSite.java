package wordPress.pages;

import wordPress.pages.insidePages.ArticlePage;
import wordPress.pages.insidePages.LoginForm;
import wordPress.pages.insidePages.SitePage;

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
    public static SitePage getSitePage(){
        return new SitePage();
    }
    public static ArticlePage getArticlePage(){
        return new ArticlePage();
    }
    public static LoginForm getLoginForm(){
        return new LoginForm();
    }
}