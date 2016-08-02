package wordPress.Tests;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.openqa.selenium.By;
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
    String postID = null;

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

    }

    @Test(description = "check delete post", enabled = true)
    public void checkDeletePost() throws JSONException, InterruptedException {
        String postID = getPostID(0);
        openPostsInBlog();
        waitPresenceElementCss(".post-controls__trash :nth-child(1)");
        pages.getAdminPanelPage().getDeletePostBtn().click();
        Assert.assertTrue(pages.getEditorPage().getDeleteMessage().isDisplayed());
        Log.info("Assert error message - pass");


        /*JSONObject json = createJsoneObject("/rest/v1.1/sites/grammsite.wordpress.com/posts");
        JSONArray jsonArray = json.getJSONArray("posts");*/

        waitPresenceElementXpath(".//div[1]/div/ul/li[3]/a");
        JSONArray jsonArray = createJsoneArray("/rest/v1.1/sites/grammsite.wordpress.com/posts", "posts");
        boolean postPresent = true;
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getString("ID").equals(postID)) {
                postPresent = false;
                break;
            }
        }
        Assert.assertTrue(postPresent);
        Log.info("Assert delete posts - pass");


        //reestablishPost();
    }

    @Test(description = "check restablishing of post", dependsOnMethods = {"checkDeletePost"}, enabled = true)
    public void checkRestablish() throws JSONException, InterruptedException {
        openPostsInBlog();
        assertPostIsAbsent("8");
        reestablishPost();
      waitPresenceElementCss(".conf-alert");
        assertPostIsPresence("8");
    }


}


