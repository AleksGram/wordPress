package wordPress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import wordPress.TestNgTestBase;



public abstract class Page {
  public WebDriverWait wait;
  public WebDriver driver = TestNgTestBase.driver;

  public void assertBgrndColor(WebElement webElement, String atribute, String atributeValue){
    wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.attributeToBeNotEmpty(webElement,atribute));
    Assert.assertEquals(webElement.getCssValue(atribute), atributeValue);
  }

  public void assertIsDisplayed(WebElement element){
    Assert.assertTrue(element.isDisplayed());
  }

  public Page() {
    PageFactory.initElements(driver, this);
  }

}
