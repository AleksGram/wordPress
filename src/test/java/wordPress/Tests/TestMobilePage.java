package wordPress.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wordPress.TestNgTestBase;
import wordPress.util.Log;


public class TestMobilePage extends TestNgTestBase {
    @BeforeMethod
    public void initLoginPage() {
        Log.info("start");
        driver.get("https://apps.wordpress.com/mobile/");
    }

    @Test(description = "presence of ios button")
    public void presenceIosBtn(){
        pages.getMobilePage().assertIsDisplayed(pages.getMobilePage().getIosButton());
    }

    @Test(description = "presence of android button")
    public void presenceAndroidBtn(){
        pages.getMobilePage().assertIsDisplayed(pages.getMobilePage().getAndroidButton());
    }

    @Test(description = "check crossing to ios page")
    public void crossToIosPage(){
        pages.getMobilePage().getIosButton().click();
        pages.getForIosPage().assertIsDisplayed(pages.getForIosPage().getIosHeader());
    }

    @Test(description = "check crossing to android page")
    public void crossToAndroidPage(){
        pages.getMobilePage().getAndroidButton().click();
        pages.getForIosPage().assertIsDisplayed(pages.getForAndroidPage().getAndroidFavicon());
    }
}
