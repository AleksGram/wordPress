package wordPress.Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wordPress.TestNgTestBase;
import wordPress.pages.StartPage;
import wordPress.util.Log;


public class TestStartPage extends TestNgTestBase {



    @BeforeMethod
    public void initStartPage() {
        Log.info("start");
        driver.get(baseUrl);
        wait=new WebDriverWait(driver, 10);
    }

//** before the separation assert method

   /* @Test(description = "check apps-link background color")
    public void checkAppsLinkBgrndColor(){
        pages.getStartPage().moveTo(pages.getStartPage().getAppsLink());
        wait.until(ExpectedConditions.attributeToBeNotEmpty(pages.getStartPage().getAppsLink(),"background-color"));
        System.out.println(pages.getStartPage().getAppsLink().getCssValue("background-color"));
        Assert.assertEquals(pages.getStartPage().getAppsLink().getCssValue("background-color"),"rgba(0, 0, 0, 0.298039)");
    }*/

    //** after separation  assert method

    @Test(description = "check apps-link background color", enabled = true)
    public void checkZAppsLinkBgrndColor() {
        TestStartPage startPage = new TestStartPage();
        pages.getStartPage().moveTo(pages.getStartPage().getAppsLink());
        startPage.assertBgrndColor(pages.getStartPage().getAppsLink(), "background-color", "rgba(0, 0, 0, 0.298039)");

    }

   @Test(description = "check themes-link background color", enabled = true)
    public void checkThemesLinkBgrndColor()  {
       TestStartPage startPage = new TestStartPage();
        pages.getStartPage().moveTo(pages.getStartPage().getThemesLink());
        startPage.assertBgrndColor(pages.getStartPage().getThemesLink(),"background-color", "rgba(0, 0, 0, 0.298039)");

    }


    @Test(description = "check bgrd-color of signIn Button", enabled = true)
    public void checkSignInBtnColor()  {
        TestStartPage startPage = new TestStartPage();
        pages.getStartPage().moveTo(pages.getStartPage().getSignInButton());
        startPage.assertBgrndColor(pages.getStartPage().getSignInButton(),
                "background","rgb(0, 170, 220) none repeat scroll 0% 0% / auto padding-box border-box");

    }
    @Test(description = "check bgrd-color of the createSite Button", enabled = true)
    public void checkCreateSiteBtnColor()  {
        TestStartPage startPage = new TestStartPage();
        pages.getStartPage().moveTo(pages.getStartPage().getCreateSiteButton());
        startPage.assertBgrndColor(pages.getStartPage().getCreateSiteButton(), "background",
                "rgb(0, 170, 220) none repeat scroll 0% 0% / auto padding-box border-box");

    }
    @Test(description = "check crossing on LoginPage", enabled = true)
    public void checkCrossOnLoginPage()  {
        pages.getStartPage().goToLoginPage();
        Assert.assertTrue(pages.getLoginPage().getLoginForm().isDisplayed());
        driver.get(baseUrl);

    }

    }



