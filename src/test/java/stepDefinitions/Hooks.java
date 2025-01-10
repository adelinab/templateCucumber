package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import utils.TestContextSetUp;

public class Hooks {

	TestContextSetUp testContextSetup;
	
	public Hooks(TestContextSetUp testContextSetup) 
	{
		this.testContextSetup = testContextSetup;
	}
	
	
	@After
	public void AfterScenario() throws IOException {
		//testContextSetup.testBase.WebDriverManager().quit();
	}
}
