package wordPress;

import java.io.IOException;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
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

import wordPress.pages.PagesOfTheSite;
import wordPress.util.Log;
import wordPress.util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase extends JerseyTest {

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

    @BeforeMethod
    public void initWebDriver() {
        driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        Log.info("the end of all");
        WebDriverFactory.dismissAll();
    }

    public WebResource webResource = client().resource("https://public-api.wordpress.com");

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public JSONObject createJsoneObject(String path) {
        JSONObject name = webResource.path(path)
                .get(JSONObject.class);
        return name;
    }

    public JSONObject createJsoneObject() {
        String resourse = "https://public-api.wordpress.com";
        String path = "/rest/v1.1/sites/sergeywebdrivertest.wordpress.com/posts/180/likes/";

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

    public void waitPresenceElement(String selector) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(selector)));
    }
}