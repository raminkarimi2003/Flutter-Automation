package pageObject;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class connectionAlert {
	public connectionAlert(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	
	
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Connection could not be established. Please ensure that:']")
	public List<WebElement> connection;
	
	public List<WebElement> ConnectionAlert()
	{
		return connection;
	}
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Cancel']")
	public WebElement cancel;
	
	public WebElement Cancel()
	{
	   return cancel;
	}
	
	@FindBy(xpath="//XCUIElementTypeOther[@name='Alert']")
	public List<WebElement> connectionError;
	
	public List<WebElement> ConnectionError()
	{
	   return connectionError;
	}

	
	@FindBy(xpath="//XCUIElementTypeButton[@name='RETRY']")
	public WebElement Retry;
	
	
}
