package utils;

import org.openqa.selenium.WebElement;

/**
 * <p>
 * Wrapper class for Element actions done by the WebDriver
 * </p>
 * Can add custom Exceptions as well as loggers for each and every element action
 * @author Singh
 *
 */
public class ElementActions {
	
	/**
	 * <p>
	 * Clicks on the provided WebElement
	 * </p>
	 * @param element The element to be clicked on
	 */
	public static void clickElement(WebElement element) {
		try {
			element.click();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * <p>
	 * Enters string value on the provided WebElement
	 * </p>
	 * @param element Element on which to send keys
	 * @param keysToSend String to send on provided WebElement
	 */
	public static void sendKeys(WebElement element, String keysToSend) {
		try {
			element.sendKeys(keysToSend);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
