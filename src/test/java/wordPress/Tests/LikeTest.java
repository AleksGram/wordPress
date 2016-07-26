package wordPress.Tests;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import wordPress.TestNgTestBase;


public class LikeTest extends TestNgTestBase {

    private String login = "grammsite";    //your WordPress login
    private String pass = "civiced1986";      //your WordPress password

    private String path="/rest/v1.1/sites/grammsite.wordpress.com/posts/4/likes/";

    @BeforeMethod
    public void precondition() {
        navigateToURL("https://grammsite.wordpress.com");
    }


    @Test(description = "verify presence/miss of the likes", enabled = true)

    public void checkLike() throws JSONException {

        JSONObject json = createJsoneObject(path);
        Assert.assertEquals(json.get("found"), 0);
        //System.out.println("before ckick "+json.get("found"));

        pages.getSitePage().getListOfArticles().get(0).click();
        waitPresenceElement(".post-likes-widget.jetpack-likes-widget");
        switchToFrame(".post-likes-widget.jetpack-likes-widget");
        pages.getArticlePage().getLikeButton().click();

        switchToWindow(1);

        pages.getLoginForm().typeLogin(login);
        pages.getLoginForm().typePasswd(pass);
        pages.getLoginForm().clickSubmtButton();

        //--reclick
        switchToWindow(0);
        waitPresenceElement(".post-likes-widget.jetpack-likes-widget");
        switchToFrame(".post-likes-widget.jetpack-likes-widget");
        waitPresenceElement(".sd-button.liked");
        pages.getArticlePage().getLikeButtonAfterLike().click();


        JSONObject json2 = createJsoneObject(path);
        Assert.assertEquals(json2.get("found"), 1);
        //System.out.println("after ckick "+json2.get("found"));
    }
}