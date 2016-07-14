package wordPress;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import wordPress.pages.StartPage;

public class SampleTestNgTest extends TestNgTestBase {

  private StartPage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, StartPage.class);
  }


}
