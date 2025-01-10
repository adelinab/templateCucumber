package stepDefinitions;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.OfferPage;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetUp;

public class OfferPageStepDefinition {
	
	TestContextSetUp testContextSetUp;
	public String landingPageproductName;
	public String offersPageProductName;
	
	public WebDriver driver;

	 OfferPage offerPage;
	 LandingPage landingPage;
	
	public OfferPageStepDefinition(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.offerPage = testContextSetUp.pageObjectManager.getOfferPage();
	    this.landingPage = testContextSetUp.pageObjectManager.getLandingPage();
	}
	
	
   
    
	@Then("^user searched for same shortname (.*) in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOffersPage();
	    
		offerPage.searchItem(shortName);
		Thread.sleep(2000);
	    offersPageProductName = offerPage.getProductName();
	    
	}
	
	public void switchToOffersPage() {
		landingPage.selectTopDealsPage();
	    testContextSetUp.genericUtils.SwitchWindowToChild();

	}
	
	
	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	   Assert.assertEquals(offersPageProductName, testContextSetUp.landingPageproductName);
	}
}
