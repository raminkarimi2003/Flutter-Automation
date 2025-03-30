package pageObject;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class finishPage {
	public finishPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(xpath="//XCUIElementTypeButton[@name='Finish']")
	public WebElement finish;
		
	@FindBy(xpath="//XCUIElementTypeButton[@name='OK']")
	public WebElement OK;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'no longer available')]")
	public List<WebElement> available;
	
	public List<WebElement> Available()
	{
		return available;
	}
}
