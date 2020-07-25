package stepDefs;

import org.openqa.selenium.WebDriver;

import cucumber.ContextMap;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UserAccountPage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;
import runner.TestRunner;

public class BasicTest extends TestRunner{
	
	WebDriver driver;
	ContextMap context;
	
	@SuppressWarnings("static-access")
	public BasicTest(TestRunner test, ContextMap brain) {
		this.driver = test.driver;
		this.context = brain;
	}
	
	@When("^I register as an (.*)$")
    public void registerAsGivenUser(String userType) {
		UserRegistrationPage urp = new UserRegistrationPage(driver, context);
		urp.pageLoader();
		urp.fillRegistrationForm();
		urp.clickSignUp();
    }
	
	@When("^I login as the registered user$")
    public void loginAsTheRegisteredUser() throws InterruptedException {
		UserLoginPage ulp = new UserLoginPage(driver, context);
		ulp.pageLoader();
		ulp.loginAsNewlyRegUser();
    }
	
	@Then("^I should be able to login$")
    public void assertLoginSuccessful() throws InterruptedException {
		UserAccountPage uap = new UserAccountPage(driver, context);
		uap.assertRegisterdUserLoggedIn();
    }
}
