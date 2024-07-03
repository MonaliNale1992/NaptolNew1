package test;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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
import pom.ProductDetailPage;
import pom.ProductResultPage;
import pom.RegistrationDetailsPage;
import utility.Reports;

@Listeners(test.Listeners.class)
public class RegistrationDetailsTest extends BaseTest {
	
	
	@BeforeTest
	public void openApplication() {
		driver = Browser.launchApplication();
	}
	 @Test
	public void verifyIfUserAbletoEnterShippingAddress() throws InterruptedException {
		
		
	    searchProduct("cooker");
	    productResultPage = new ProductResultPage(driver);
	    productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.clickOnBuyButton();
		cartPage = new CartPage(driver);
        cartPage.DeliveryproceedtoCheckout();
		switchToChildBrowser();

		loginPage=new LoginPage(driver);
	    loginPage.EnterMobileNumber("9922939375");
		loginPage.ClickonContinue();
		Thread.sleep(30000);
        loginPage.ClickonSubmit();


        switchToChildBrowser();
		regDetails = new RegistrationDetailsPage(driver);
		regDetails.selectTitle();
		regDetails.EnterFirstName("Ashwini");
		regDetails.EnterLastname("Ghuge");
		
		Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB);
		actions.sendKeys("Kamothe");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("SBI Bank");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys("410209");
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.sendKeys(Keys.TAB);
        actions.build().perform();
        regDetails.EnterMobileNumber("8898777185");
        Thread.sleep(2000);
        
        Thread.sleep(2000);
		regDetails.ClickonSaveandProceed();
        regDetails.ShipToThisAddress();		
	 }
	 
        
        
        @Test
        public void verifyIfUserisableToPlaceOrder() throws InterruptedException {
        	
        	
    	    searchProduct("cooker");
    	    productResultPage = new ProductResultPage(driver);
    	    productResultPage.selectDesiredProduct(0);
    		switchToChildBrowser();
    		
    		productDetailPage = new ProductDetailPage(driver);
    		productDetailPage.clickOnBuyButton();
    		cartPage = new CartPage(driver);
            cartPage.DeliveryproceedtoCheckout();
    		switchToChildBrowser();

    		loginPage=new LoginPage(driver);
    	    loginPage.EnterMobileNumber("8898777185");
    		loginPage.ClickonContinue();
    		Thread.sleep(30000);
            loginPage.ClickonSubmit();


            switchToChildBrowser();
    		regDetails = new RegistrationDetailsPage(driver);
    		regDetails.selectTitle();
    		regDetails.EnterFirstName("Monali");
    		regDetails.EnterLastname("Nale");
    		
    		Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB);
    		actions.sendKeys("Kamothe");
            actions.sendKeys(Keys.TAB);
            actions.sendKeys("SBI Bank");
            actions.sendKeys(Keys.TAB);
            actions.sendKeys("410209");
            actions.sendKeys(Keys.TAB);
            actions.sendKeys(Keys.TAB);
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
            regDetails.EnterMobileNumber("8898777185");
            Thread.sleep(2000);
            
            Thread.sleep(2000);
    		regDetails.ClickonSaveandProceed();
            regDetails.ShipToThisAddress();		
		    Thread.sleep(2000);
	        regDetails.selectpaymentOptions(0);	
	        Thread.sleep(2000);;
	        //regDetails.checkTermsandPrivacyPolicy();
	        //Thread.sleep(2000);
	        //regDetails.ClickHereToPlaceOrder();	
	   
             Assert.assertTrue(regDetails.isPaymentOptionDisplayed());
	}
	
	 
	 @AfterMethod
	   
		public void closeNaaptol () {
			driver.close();

   }

	
	
}
