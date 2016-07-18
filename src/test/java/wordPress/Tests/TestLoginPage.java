package wordPress.Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import wordPress.TestNgTestBase;
import wordPress.util.ExcelUtils;
import wordPress.util.Log;

/**
 * Created by Грам on 05.07.2016.
 */
public class TestLoginPage extends TestNgTestBase {
    @BeforeMethod
    public void initLoginPage() {
        Log.info("start");
        driver.get("https://ru.wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fru.wordpress.com%2F");

    }

    @Test(description = "email field is backlighed after submitt with empty fields")
    public void testEmailField() {
        pages.getLoginPage().clickSubmittButton();
        Assert.assertEquals(pages.getLoginPage().checkBorderColor(), "1px solid rgb(200, 215, 225)");

    }

    @Test(description = "error message is shown in login form")
    public void checkErrorMessage() {
        pages.getLoginPage().typeLogin("login");
        pages.getLoginPage().clickSubmittButton();
        Assert.assertTrue(pages.getLoginPage().getErrorMsg().isDisplayed());
    }

    @DataProvider(name = "ExcelData", parallel = false)

    public Object[][] credentials() {
        Object[][] testObjArray = ExcelUtils.getTableArray("D:\\LoginData.xlsx", "Лист1");
        return testObjArray;
    }

    @Test(dataProvider = "ExcelData")
    public void userLogin(String login, String passwd)  {


        pages.getLoginPage().typeLogin(login);
        pages.getLoginPage().typePasswd(passwd);

    }
    @Test(description = "check lost password link",enabled = true)
    public void checkLostPasswdLink(){
        pages.getLoginPage().getLostPassswdLink().click();
        Assert.assertTrue(pages.getLostPasswordPage().getLostPasswdForm().isDisplayed());
    }
}
