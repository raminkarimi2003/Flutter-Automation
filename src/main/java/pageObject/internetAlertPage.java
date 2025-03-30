package pageObject;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class internetAlertPage {
	public internetAlertPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	
	@FindBy(xpath="//XCUIElementTypeOther[@name='Alert']")
	public List<WebElement> noInternetAlert;
	
	public List<WebElement> NoInternetAlert()
	{
		return noInternetAlert;
	}	
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='No Internet Connection']")
	public WebElement noInternetConnection;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
	public WebElement ok;
	
	public WebElement OK()
	{
		return ok;
	}	
  
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='No Network Connection']")
	public WebElement noNetwork;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Ok']")
	public WebElement Ok;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='NO NETWORK CONNECTION']")
	public List<WebElement> noNetworkBanner;
	
}
