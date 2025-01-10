package stepDefinitions;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetUp;


public class CheckoutPageStepDefinition {
	public CheckoutPage checkoutPage;
	
	public WebDriver driver;
	TestContextSetUp testContextSetUp;
	
	
	
	public CheckoutPageStepDefinition(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.checkoutPage = testContextSetUp.pageObjectManager.getCheckoutPage();
	}
	
	
	@Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException {

		checkoutPage.checkoutItems();
		//Thread.sleep(2000);
	}

	@Then("user has ability to enter promo code and place the order")
	public void user_has_ability_to_enter_promo_code_and_place_the_order() {

		
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
		
	}
	
	
	
	
}
