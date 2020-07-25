package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

import cucumber.ContextMap;
import enums.Context;
import utils.ElementActions;

public class UserRegistrationPage extends Page{
	
	WebDriver driver;
	ContextMap brain;
	
	public UserRegistrationPage(WebDriver driver, ContextMap brain) {
		super("register", driver);
		this.driver = driver;
		this.brain = brain;
	}
	
	private WebElement firstName;
	public WebElement firstName(){
		firstName = driver.findElement(By.xpath("//input[@name = 'firstname']"));
		return firstName;
	}
	
	private WebElement lastName;
	public WebElement lastName(){
		lastName = driver.findElement(By.xpath("//input[@name = 'lastname']"));
		return lastName;
	}
	
	private WebElement phone;
	public WebElement phone(){
		phone = driver.findElement(By.xpath("//input[@name = 'phone']"));
		return phone;
	}
	
	private WebElement email;
	public WebElement email(){
		email = driver.findElement(By.xpath("//input[@name = 'email']"));
		return email;
	}
	
	private WebElement password;
	public WebElement password(){
		password = driver.findElement(By.xpath("//input[@name = 'password']"));
		return password;
	}
	
	private WebElement cnfPassword;
	public WebElement cnfPassword(){
		cnfPassword = driver.findElement(By.xpath("//input[@name = 'confirmpassword']"));
		return cnfPassword;
	}
	
	private WebElement signUpButton;
	public WebElement signUpButton(){
		signUpButton = driver.findElement(By.xpath("//button[@type = 'submit'][@class = 'signupbtn btn_full btn btn-success btn-block btn-lg']"));
		return signUpButton;
	}
	
	
	public void fillRegistrationForm() {
		Faker faker = new Faker();
		
		String firstName = faker.name().firstName();
		brain.scenarioContext.setContext(Context.regFirstName, firstName);
		ElementActions.sendKeys(firstName(), firstName);
		
		String lastName = faker.name().lastName();
		brain.scenarioContext.setContext(Context.regLastName, lastName);
		ElementActions.sendKeys(lastName(), lastName);
		
		String mNum = faker.phoneNumber().cellPhone();
		ElementActions.sendKeys(phone(), mNum);
		
		String emailAddr = faker.internet().emailAddress();
		brain.scenarioContext.setContext(Context.regEmailAddress, emailAddr);
		ElementActions.sendKeys(email(), emailAddr);
		
		String password = faker.internet().password();
		brain.scenarioContext.setContext(Context.regPassword, password);
		ElementActions.sendKeys(password(), password);
		
		ElementActions.sendKeys(cnfPassword(), password);
	}
	
	public void clickSignUp() {
		ElementActions.clickElement(signUpButton());
	}
}
