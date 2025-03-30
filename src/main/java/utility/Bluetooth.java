package utility;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.bluetoothPage;

public class Bluetooth  {
		
	
	public static void enable(IOSDriver<WebElement>driver) throws InterruptedException
	{
		
		bluetoothPage bl=new bluetoothPage(driver);
        bl.bluetooth.click();                 // enable blue tooth for the app initially
        String bluetoothName=bl.Accept().getText(); // return the label on blue tooth pop-up
		Coordinates.Permission(bluetoothName);      
	}
	
	public static void close(IOSDriver<WebElement>driver) throws InterruptedException
	{
		
		bluetoothPage bl=new bluetoothPage(driver);
		boolean inGerman=bl.blaktivieren.size()>0;
		if(inGerman)
		{
			String bluetoothName=bl.schliBen.getText(); // return the label on blue tooth pop-up
			Coordinates.Permission(bluetoothName); 
		}
		else
		{	
        String bluetoothName=bl.Close.getText(); // return the label on blue tooth pop-up
		Coordinates.Permission(bluetoothName);     
		}
	} 
}