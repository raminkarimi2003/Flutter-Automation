package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class endRentalConfirmationPage {

	public endRentalConfirmationPage(AppiumDriver<WebElement> driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//XCUIElementTypeOther[@name='Alert']")
	public List<WebElement> endRentalAlert;
	
	public List<WebElement> EndRentalAlert()
	{
		 return endRentalAlert;
	}
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='END RENTAL']")  // end rental on the confirmation dialog
	public WebElement endRentalConfirmation;

	
	
}
