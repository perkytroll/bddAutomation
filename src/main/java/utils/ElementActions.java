package utils;

import org.openqa.selenium.WebElement;

public class ElementActions {
	public static void clickElement(WebElement element) {
		try {
			element.click();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void sendKeys(WebElement element, String keysToSend) {
		try {
			element.sendKeys(keysToSend);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
