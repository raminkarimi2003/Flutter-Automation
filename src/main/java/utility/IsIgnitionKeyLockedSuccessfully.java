package utility;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.bluetoothPage;
import pageObject.checkEquipmentPage;

public class IsIgnitionKeyLockedSuccessfully  {
		
	
		
	
	
	public static  boolean check (IOSDriver<WebElement>driver) throws InterruptedException
	{
		
		checkEquipmentPage ch=new checkEquipmentPage(driver);
        boolean flag=ch.Check().size()>0;
        return flag;
	} 
	
}