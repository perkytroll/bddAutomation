package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.ContextMap;
import enums.Context;
import utils.ElementActions;
import utils.Helpers;
import utils.TestAssertions;

/**
 * <p>
 * Class defining elements and methods for landing page (Account page) after a user signs In
 * </p>
 * @author Singh
 *
 */
public class UserAccountPage extends Page{
	
	public WebDriver driver;
	public ContextMap brain;
	
	/**
	 * <p>
	 * Constructor to initialize driver and Scenario context
	 * </p>
	 * @param driver driver instance for current scenario
	 * @param brain Context Map for current Scenario
	 */
	public UserAccountPage(WebDriver driver, ContextMap brain) {
		super("account/", driver);
		this.driver = driver;
		this.brain = brain;
	}
	
	
	/**
	 * <p>
	 * Page Elements
	 * </p>
	 */
	private WebElement firstName;
	public WebElement firstName(){
		firstName = driver.findElement(By.xpath("//input[@name = 'firstname']"));
		return firstName;
	}
	
	private WebElement myProfileTab;
	String myProfileExpression = "//a[@href = '#profile']";
	public WebElement myProfileTab(){
		myProfileTab = driver.findElement(By.xpath(myProfileExpression));
		return myProfileTab;
	}
	
	/**
	 * <p>
	 * Logs in the user that has been saved in the Scenario Context (Newly registered user)
	 * </p>
	 */
	public void assertRegisterdUserLoggedIn() {
		Helpers helpers = new Helpers(driver);
		helpers.waitForElementToExist(myProfileExpression);
		ElementActions.clickElement(myProfileTab());
		TestAssertions.verifyAssertEqual(firstName().getAttribute("value"), (String)brain.scenarioContext.getContext(Context.regFirstName));
	}
}
