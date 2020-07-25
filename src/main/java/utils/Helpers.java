package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * <p>
 * Common functions that can be used throughout the tests
 * </p>
 * @author Singh
 *
 */
public class Helpers {
	
	public WebDriver driver;
	
	/**
	 * <p>
	 * Initializes the driver instance to be used in these tests
	 * </p>
	 * @param driver driver instance for the running Scenario
	 */
	public Helpers(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * <p>
	 * Retrieves the OS on which the Suite is being executed
	 * </p>
	 * @return returns the name of OS
	 */
	public static String getOSName()
	{
		String OSName= "";
		try
		{
			OSName = System.getProperty("os.name");
		} 
		catch (Exception e )
		{
			OSName = "unknown";
		}
		return OSName;
	}
	
	/**
	 * <p>
	 * Waits for an elemnt's visibility for specified amount of time
	 * </p>
	 * @param element element for which to wait
	 */
	public void explicitWait(WebElement element) {
		WebDriverWait wait  = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * <p>
	 * Fluently waits for the specified element to start existing for the specified amount of time
	 * </p>
	 * @param xpathExpression Xpath expression for the element
	 */
	public void waitForElementToExist(String xpathExpression) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                int elementCount = driver.findElements(By.xpath(xpathExpression)).size();
                if (elementCount > 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
        });
    }
}
