package wordPress.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wordPress.TestNgTestBase;
import wordPress.util.Log;

/**
 * Created by Грам on 05.07.2016.
 */
public class TestCreateSitePage extends TestNgTestBase {
    @BeforeMethod
    public void initCreateSitePage() {
        Log.info("start");
        driver.get("https://wordpress.com/start/website/ru/?ref=homepage");

    }

    @Test(description = "menu of the create of site is presence")
    public void checkMenuIsPresense() {
        wait.until(ExpectedConditions.visibilityOfAllElements(pages.getCreateSitePage().getMenuList()));
            Assert.assertTrue(pages.getCreateSitePage().getMenuList().size()==6);
    }


    @Test(description = "check models of the site is visible")
    public void checkModelsOfSite() {
        for (WebElement itemMenu : pages.getCreateSitePage().getMenuList()) {
            wait.until(ExpectedConditions.elementToBeClickable(itemMenu));
            Log.info("1-st cycle");
            itemMenu.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(pages.getCreateSitePage().getMenuList()));
            for(WebElement subMenu:pages.getCreateSitePage().getMenuList()) {
                Actions builder = new Actions(driver);
                builder.click(subMenu);
                Log.info("2-nd cycle");
                Action clickItem = builder.build();
                clickItem.perform();
               Assert.assertTrue(pages.getCreateSitePage().getModelForm().isDisplayed());
                break;
            }
            break;

        }

    }
    @Test(description = "check presence of the site models")
                public void checkPresenceOfModelSiteForm(){
                    pages.getCreateSitePage().assertPresenceOfModelForm();

    }



}





