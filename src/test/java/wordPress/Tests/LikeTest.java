package wordPress.Tests;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import wordPress.TestNgTestBase;


public class LikeTest extends TestNgTestBase {

    private String login = "*****";
    private String pas = "*****";
    private String path="/rest/v1.1/sites/grammsite.wordpress.com/posts/4/likes/";

    @BeforeMethod
    public void precondition() {
        navigateToURL("https://grammsite.wordpress.com");
    }


    @Test(description = "verify presence/miss of the likes", enabled = true)

    public void checkLike() throws InterruptedException, JSONException {

        JSONObject json = createJsoneObject(path);
        Assert.assertEquals(json.get("found"), 0);

        pages.getSitePage().getListOfArticles().get(0).click();
        waitPresenceElement(".post-likes-widget.jetpack-likes-widget");
        switchToFrame(".post-likes-widget.jetpack-likes-widget");
        pages.getArticlePage().getLikeButton().click();

        switchToWindow(1);

        pages.getLoginForm().typeLogin(login);
        pages.getLoginForm().typePasswd(pas);
        pages.getLoginForm().clickSubmtButton();

        JSONObject json2 = createJsoneObject(path);
        Assert.assertEquals(json.get("found"), 0);
    }
}
