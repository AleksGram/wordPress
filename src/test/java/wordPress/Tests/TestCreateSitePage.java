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

    @Test(description = "presentce of the creating site menu")
    public void presenceMenu() {

        wait.until(ExpectedConditions.visibilityOfAllElements(pages.getCreateSitePage().getMenuList()));
        for (WebElement itemMenu : pages.getCreateSitePage().getMenuList()) {
            System.out.println(itemMenu.getCssValue("innerText"));
            Assert.assertTrue(itemMenu.isDisplayed());
        }

    }


    @Test(description = "check menu items")//not work yet!!!
    public void checkMenuItems() {
        wait.until(ExpectedConditions.visibilityOfAllElements(pages.getCreateSitePage().getMenuList()));

        for (WebElement itemMenu : pages.getCreateSitePage().getMenuList()) {
            wait.until(ExpectedConditions.elementToBeClickable(itemMenu));
            itemMenu.click();

            for(WebElement subMenu:pages.getCreateSitePage().getMenuList()) {
                Actions builder = new Actions(driver);
                builder.click(itemMenu);
                Action clickItem = builder.build();
                clickItem.perform();

                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.step-wrapper__buttons")));
                pages.getCreateSitePage().clickDownBackButton();

            }

           // pages.getCreateSitePage().clickBackButton();

        }

    }
    @Test
    public void test(){
        for(int i=0; i<pages.getCreateSitePage().getMenuList().size(); i++){
            WebElement element=pages.getCreateSitePage().getMenuList().get(i);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            for(int j=0;j<pages.getCreateSitePage().getMenuList().size(); j++){
                WebElement  subElement=pages.getCreateSitePage().getMenuList().get(i);
                wait.until(ExpectedConditions.elementToBeClickable(subElement));
                subElement.click();
                pages.getCreateSitePage().getDownBackButton().click();
            }
           // pages.getCreateSitePage().getBackButton().click();
        }
    }


}





