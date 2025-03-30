package pageObject;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;


public class drivePage {
	public drivePage(AppiumDriver<?> driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	
	@FindBy(xpath="//XCUIElementTypeOther[@name='Alert']")
	public WebElement endRentalAlert;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='NO EQUIPMENT SELECTED']")
	public WebElement NoEquipmentSelected;
	
	@FindBy(xpath="//XCUIElementTypeImage[@name='Tap to lock']")
	public WebElement locked;
	
	@FindBy(xpath="//XCUIElementTypeImage[@name='Tap to unlock']")
	public WebElement unlocked;
	
	@FindBy(xpath="//XCUIElementTypeImage[@name='Tap to lock']")
	public List<WebElement> unlockedStatus;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='End rental']") // end rental on the drive(main screen)
	public WebElement endRental;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='END RENTAL']")  // end rental on the confirmation dialog
	public WebElement endRentalConfirmation;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Get help with your equipment']")
	public WebElement equipmentHelp;
	
	public WebElement EquipmentHelp()
	{
		return equipmentHelp;
	}

	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'ID:')]") // Referring to license plate ID
	public WebElement DriveID;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[contains(@name,'Rental ends in')]") // Referring to end rental remaining
	public WebElement rentalRemaining;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Equipment\nTab 2 of 5']") // refer to equipment tab
	public WebElement Equipment;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Use your equipment']") // Referring to string inside "Get help with your  equipment"
	public WebElement helpString;
      	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='DRIVE']") // Referring to icon
	public WebElement Drive;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name='Dismiss']")    // dismiss the no Internet banner
	public WebElement dismiss;
	
	@FindBy(xpath="//XCUIElementTypeStaticText[@name=\"BACKHOE 4WD 18' EXT\"]")    // expected Asset element in Drive
	public WebElement assetInDrive;
	
	
	
}