package utility;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.bluetoothPage;

public class BLEConnection  {
		
	
		
	public static void cancel(IOSDriver<WebElement>driver) throws InterruptedException
	{
		
		bluetoothPage bl=new bluetoothPage(driver);
        String bluetoothName=bl.Cancel.getText(); // return the label on blue tooth pop-up
		Coordinates.Permission(bluetoothName);      
	} 
	
	public static void ok(IOSDriver<WebElement>driver) throws InterruptedException
	{
		
		bluetoothPage bl=new bluetoothPage(driver);
        String bluetoothName=bl.Ok.getText(); // return the label on blue tooth pop-up
		Coordinates.Permission(bluetoothName);      
	} 
	
}