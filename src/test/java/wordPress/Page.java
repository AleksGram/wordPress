package wordPress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordPress.TestNgTestBase;



public abstract class Page {
  public WebDriverWait wait;


  public WebDriver driver = TestNgTestBase.driver;
  //protected WebDriver driver;
  // protected PagesOfTheSite pages;

  /*
   * Constructor injecting the WebDriver interface
   *
   * @param webDriver
   */
  public Page() {
    PageFactory.initElements(driver, this);
  }

}
