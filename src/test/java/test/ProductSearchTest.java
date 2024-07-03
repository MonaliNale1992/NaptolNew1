package test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.LoginPage;
import pom.NaptolHomePage;
import pom.ProductDetailPage;
import pom.ProductResultPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class ProductSearchTest extends BaseTest {

	@BeforeMethod
	public void openApplication() {
		driver =Browser.launchApplication();
	}
	
	@Test
	public void verifyIfUserIsAbleRoSerachProduct() {
		
	searchProduct("toys");
	naptolHomePage.clickOnSearch();
	Assert.assertTrue(driver.getTitle().contains("toys"));
	Assert.assertTrue(naptolHomePage.getNumberOfProductDisplayed()>0);
		
	}
	
	
	
	@Test
    public void verifyIfUserIsAbletologin() {
	NaptolHomePage naptolHomePage=new NaptolHomePage(driver);
    naptolHomePage.clickOnLoginOrRegister();
	
	
	Assert.assertTrue(naptolHomePage.IsLoginOrRegisterPopupdisplayed());
	Assert.assertTrue(naptolHomePage.IsLoginOrRegisterTextdisplayed());
	
   }
	
    @Test
    public void verifyIfUserIsAbleToTrackorder() {
	NaptolHomePage naaptolHomePage = new NaptolHomePage(driver);
	naptolHomePage.clickOnTrackOrder();
	naptolHomePage.istrackordertitleDisplayed();
	naptolHomePage.EnterorderID("12345");
	Assert.assertEquals(true, naaptolHomePage.istrackordertitleDisplayed());
	
   }
    
   @Test
    public void verifyIfUserisabletoaccessshoppingcategories() {
	NaptolHomePage naaptolHomePage = new NaptolHomePage(driver);
    naptolHomePage.viewShoppingCategories(driver);
	Assert.assertTrue(naaptolHomePage.isListItemDisplayed());
	
  }
   
   @AfterMethod
   
	public void closeNaaptol () {
		driver.close();

  }
}
