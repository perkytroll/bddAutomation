package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {
	
	WebDriver driver;
	
	public Helpers(WebDriver driver) {
		this.driver = driver;
	}
	
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
	
	public void explicitWait(WebElement element) {
		WebDriverWait wait  = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
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
