package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class equipmentDetailsPage {
	public equipmentDetailsPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	@FindBy(xpath="//XCUIElementTypeButton[@name='Start Rental']")
	public WebElement startRental;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Get help with your rental']")
	public WebElement rentalHelp;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Are you sure you want to call 813-626-3470']")
	public WebElement call;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='YES']")
	public WebElement confirmRental;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Continue']")
	public WebElement Continue;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Booking ID:')]") // Referring to license plate ID under rented Equipment tab
	public WebElement equipmentDetailsID;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'ID')]") // Referring to license plate ID under rented Equipment tab
	public WebElement equipmentID;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Use Equipment']")
	public WebElement useEquipment;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Change end date']")
	public WebElement ChangeEndDate;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Done']")
	public WebElement ChangeEndDateClose;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='FINISH']")
	public WebElement finish;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Back']")
	public WebElement backArrow;
	
	@FindBy(xpath="//XCUIElementTypeOther[@name=\"Equipment details \"]")
	public List<WebElement> equipmentDetails;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name=\"BACKHOE 4WD 18' EXT\"]")    // expected Asset element in Drive
	public WebElement rentedAsset;

	public WebElement RentedAsset() {
		return rentedAsset;
	}
	
	
}

