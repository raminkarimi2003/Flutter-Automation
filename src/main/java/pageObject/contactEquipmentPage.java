package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class contactEquipmentPage {
	public contactEquipmentPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='UNLOCK & GET STARTED']")
	public WebElement unlockGetStarted;
	
}
