package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.ContextMap;
import enums.Context;
import utils.ElementActions;
import utils.Helpers;
import utils.TestAssertions;

public class UserAccountPage extends Page{
	
	WebDriver driver;
	ContextMap brain;
	
	public UserAccountPage(WebDriver driver, ContextMap brain) {
		super("account/", driver);
		this.driver = driver;
		this.brain = brain;
	}
	
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
	
	public void assertRegisterdUserLoggedIn() {
		Helpers helpers = new Helpers(driver);
		helpers.waitForElementToExist(myProfileExpression);
		ElementActions.clickElement(myProfileTab());
		TestAssertions.verifyAssertEqual(firstName().getAttribute("value"), (String)brain.scenarioContext.getContext(Context.regFirstName));
	}
}
