package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class callPage {
	public callPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Make a call']")
	public WebElement makeCall;
		
	@FindBy(xpath="//XCUIElementTypeStaticText[@label='2064227082']")
	public WebElement CallHelpLines;
	
	@FindBy(xpath="//XCUIElementTypeButton[@label='OK']")
	public WebElement ok;
	
}
