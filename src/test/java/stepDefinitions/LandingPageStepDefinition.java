package stepDefinitions;
import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetUp;


public class LandingPageStepDefinition {
	public String landingPageproductName;
	public String offersPageProductName;
	
	public WebDriver driver;
	TestContextSetUp testContextSetUp;
	
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.landingPage = testContextSetUp.pageObjectManager.getLandingPage();
	}
	
	
	

	@Given("user is on greencart landing page")
	public void user_is_on_greencart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	
	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
	
		landingPage.searchItem(shortName);
		//testContextSetUp.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	   Thread.sleep(1000);
	   testContextSetUp.landingPageproductName=landingPage.getProductName().split("-")[0].trim();

	}
	
	@When("added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity){
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	
	
	
}
