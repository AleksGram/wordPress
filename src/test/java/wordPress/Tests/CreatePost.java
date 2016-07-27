package wordPress.Tests;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wordPress.TestNgTestBase;
import wordPress.util.Log;

/**
 * Created by User on 26.07.2016.
 */
public class CreatePost extends TestNgTestBase {

    @BeforeMethod
    public void initLoginPage() {
        Log.info("start");
        driver.get("https://ru.wordpress.com/wp-login.php");
        fillLoginForm();
        wait = new WebDriverWait(driver, 10);

    }

    @Test(description = "check create post", enabled = true)
    public void createPostTest() throws JSONException {
        wait.until(ExpectedConditions.elementToBeClickable(pages.getAdminWPPage().getCreateNewButton()));
        pages.getAdminWPPage().getCreateNewButton().click();

        wait.until(ExpectedConditions.visibilityOf(pages.getEditorPage().getPostTitle()));
        pages.getEditorPage().getPostTitle().sendKeys("Hillel auto");

        pages.getEditorPage().clickHtmlBtn();
        pages.getEditorPage().getDescription().sendKeys("Hillel description");
        pages.getEditorPage().getPublishButton().click();


        JSONArray jsonArray = createJsoneArray("/rest/v1.1/sites/grammsite.wordpress.com/posts", "posts");
        boolean postCreated = false;
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getString("title").equals("Hillel auto")) {
                postCreated = true;
                break;
            }
        }
        Assert.assertTrue(postCreated);
        System.out.println(getPostID(0));

    }

    @Test(description = "check delete post", enabled = true)
    public void checkDeletePost() throws JSONException {
        String postID = getPostID(0);

        waitPresenceElementCss(".masterbar__item");
        pages.getAdminPanelPage().getMySiteBtn().click();
        waitPresenceElementCss(".posts");
        pages.getAdminPanelPage().getShowPostsItem().click();
        waitPresenceElementCss(".post-controls__trash :nth-child(1)");
        pages.getAdminPanelPage().getDeletePostBtn().click();
        Assert.assertTrue(pages.getEditorPage().getDeleteMessage().isDisplayed());

        //before
        /*JSONObject json = createJsoneObject("/rest/v1.1/sites/grammsite.wordpress.com/posts");
        JSONArray jsonArray = json.getJSONArray("posts");*/

        //after
        JSONArray jsonArray = createJsoneArray("/rest/v1.1/sites/grammsite.wordpress.com/posts", "posts");

        boolean postPresent = true;
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getString("ID").equals(postID)) {
                postPresent = false;
                break;
            }
        }
        Assert.assertTrue(postPresent);

        reestablishPost();
    }


}


