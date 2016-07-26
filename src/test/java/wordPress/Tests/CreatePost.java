package wordPress.Tests;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
  /*  @BeforeMethod
    public void initLoginPage() {
        Log.info("start");
      driver.get("https://ru.wordpress.com/wp-login.php");
        wait=new WebDriverWait(driver, 10);
    }*/
    @Test
    public void createPostTest() throws JSONException {
       /* pages.getLoginPage().typeLogin("grammsite");
        pages.getLoginPage().typePasswd("civiced1986");
        pages.getLoginPage().clickSubmittButton();
        wait.until(ExpectedConditions.elementToBeClickable(pages.getAdminWPPage().getCreateNewButton()));
        pages.getAdminWPPage().getCreateNewButton().click();

        wait.until(ExpectedConditions.visibilityOf(pages.getEditorPage().getPostTitle()));
        pages.getEditorPage().getPostTitle().sendKeys("Hillel tets Auto");

        pages.getEditorPage().clickHtmlBtn();
        pages.getEditorPage().getDescription().sendKeys("Hillel description");
        pages.getEditorPage().getPublishButton().click();*/


      //JSONObject json = webResource.path("/rest/v1.1/sites/grammsite.wordpress.com/posts").get(JSONObject.class);
        JSONObject json =createJsoneObject("/rest/v1.1/sites/grammsite.wordpress.com/posts");
        JSONArray jsonArray=json.getJSONArray("posts");
        System.out.println(jsonArray.getJSONObject(0).getString("title"));
        boolean postCreated = false;
        for (int i=0; i<jsonArray.length(); i++){
          if(jsonArray.getJSONObject(i).getString("title").equals("Hillel auto")){
              postCreated=true;
              break;
          }
        }
        Assert.assertTrue(postCreated);
           }



}
