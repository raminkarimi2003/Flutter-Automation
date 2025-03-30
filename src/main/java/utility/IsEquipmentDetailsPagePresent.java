package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.camerPermissionPage;
import pageObject.endRentalConfirmationPage;
import pageObject.equipmentDetailsPage;

public class IsEquipmentDetailsPagePresent  {
		
	
	public static void Check(IOSDriver<WebElement>driver,String text) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  		// implicit time out
		equipmentDetailsPage eq=new equipmentDetailsPage(driver);
		if(driver.findElementByXPath("//*[contains(normalize-space(@name),'"+text+"')]").isDisplayed()) {
			eq.backArrow.click(); // Arrow back (on page)
			
		}
				
	
	}
}  



