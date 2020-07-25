package pages;

import org.openqa.selenium.WebDriver;

public class Page {
	
	protected String baseUrl = "https://www.phptravels.net/";
	protected String pageUrl;
	WebDriver driver;
	
	public Page(String pageUrl, WebDriver driver) {
		this.pageUrl = pageUrl;
		this.driver = driver;
	}
	
	public void pageLoader() {
		driver.get(baseUrl + pageUrl);
	}
}
