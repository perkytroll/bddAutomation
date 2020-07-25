package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.testng.TestNGCucumberRunner;
import utils.Helpers;

public class BrowserAndTestManager {
	
	protected TestNGCucumberRunner testNGCucumberRunner;
	public static WebDriver driver;
	
	public void initialiseBrowserInstance(String browserType) throws Exception {
		if (Helpers.getOSName().toLowerCase().indexOf("win") >= 0){
			switch(browserType) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			}
		}
		else {
			switch(browserType) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "./chromedriver");
				driver = new ChromeDriver();
				break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", "./geckodriver");
				driver = new FirefoxDriver();
				break;
			}
		}
		driver.manage().window().maximize();
	}
	
	public void setupEnvironment(String env) {
		switch(env) {
		case "Test":
			driver.get("https://phptravels.com/demo/");
			break;
			
		default:
			break;
		}
	}
	
}
