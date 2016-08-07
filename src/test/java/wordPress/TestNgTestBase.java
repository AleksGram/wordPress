package wordPress;

import java.io.IOException;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import wordPress.util.Log;
import wordPress.util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase extends JerseyTest {
    public String login = "***";  //yuor wordPress login
    public String pass = "***"; //your wordPress password

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder().build();
    }

    protected static String gridHubUrl;
    protected static String baseUrl;
    protected static Capabilities capabilities;
    protected static PagesOfTheSite pages;

    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeSuite
    public void initTestSuite() throws IOException {
        baseUrl = PropertyLoader.loadProperty("site.url");
        gridHubUrl = PropertyLoader.loadProperty("grid.url");
        if ("".equals(gridHubUrl)) {
            gridHubUrl = null;
        }
        capabilities = PropertyLoader.loadCapabilities();
        System.setProperty("webdriver.chrome.driver", "C:\\server\\chromedriver.exe");
        WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    }

    /*@BeforeMethod
    public void initWebDriver() {
        driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
        wait = new WebDriverWait(driver, 10);
    }*/

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Log.info("the end of all");
        WebDriverFactory.dismissAll();
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public WebResource webResource = client().resource("https://public-api.wordpress.com");


    public JSONObject createJsoneObject(String path) {
        JSONObject name = webResource.path(path)
                .get(JSONObject.class);
        return name;
    }

    public JSONObject createJsoneObject(String resourseUrl, String pathRequest) {
        String resourse = resourseUrl;
        String path = pathRequest;

        WebResource webResource = client().resource(resourse);
        JSONObject name = webResource.path(path)
                .get(JSONObject.class);
        return name;
    }

    public void switchToFrame(String selector) {
        driver.switchTo().frame(driver.findElement(By.cssSelector(selector)));
    }

    public void switchToWindow(int level) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[level].toString());
    }

    public void waitPresenceElementCss(String selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }

    public void waitPresenceElementXpath(String selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(selector)));
    }

    public void waitVisabilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void fillLoginForm() {
        pages.getLoginPage().typeLogin(login);
        pages.getLoginPage().typePasswd(pass);
        pages.getLoginPage().clickSubmittButton();
    }

    public void reestablishPost() {
        waitPresenceElementXpath(".//div[1]/div/ul/li[3]");
        pages.getEditorPage().clickInBasketBtn();
        waitPresenceElementCss(".post-controls__restore");
        pages.getEditorPage().clickReestablishBtn();
        waitPresenceElementCss(".conf-alert");
    }

    public JSONArray createJsoneArray(String path, String key) throws JSONException {
        JSONObject json = createJsoneObject(path);
        JSONArray name = json.getJSONArray(key);
        return name;
    }

    public String getPostID(int postNumber) throws JSONException {
        JSONArray jsonArray = createJsoneArray("/rest/v1.1/sites/grammsite.wordpress.com/posts", "posts");
        return jsonArray.getJSONObject(postNumber).getString("ID");

    }

    public void assertPostIsPresence(String postID) throws JSONException {
        JSONArray jsonArray = createJsoneArray("/rest/v1.1/sites/grammsite.wordpress.com/posts", "posts");
        boolean presenceInPosts = false;
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getString("ID").equals(postID)) {
                presenceInPosts = true;
                break;
            }
            Assert.assertTrue(presenceInPosts);

        }
    }

    public void assertPostIsAbsent(String postID) throws JSONException {
        JSONArray jsonArray = createJsoneArray("/rest/v1.1/sites/grammsite.wordpress.com/posts", "posts");
        boolean absentInPosts = true;
        for (int i = 0; i < jsonArray.length(); i++) {
            if (jsonArray.getJSONObject(i).getString("ID").equals(postID)) {
                absentInPosts = false;
                break;
            }
            Assert.assertTrue(absentInPosts);

        }
    }

    public void openPostsInBlog(){
        waitPresenceElementCss(".masterbar__item");
        pages.getAdminPanelPage().getMySiteBtn().click();
        waitPresenceElementCss(".posts");
        pages.getAdminPanelPage().getShowPostsItem().click();
    }
}