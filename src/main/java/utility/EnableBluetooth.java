package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.bluetoothPage;

public class EnableBluetooth {
	private static IOSDriver<?> driver;   // declare local driver
	public EnableBluetooth(IOSDriver<?> driver)
	{
		EnableBluetooth.driver=driver;   // assigned the driver to local driver
	}
	
		
	
	public static void enable(boolean expectedBLESTATUS) throws InterruptedException
	{
		//bluetoothPage bl=new bluetoothPage(driver);
		driver.findElementByXPath("//XCUIElementTypeCell[@visible='true' and @name='Bluetooth']").click();
		if(isBluetoothEnabled()!=expectedBLESTATUS)
		{
			Thread.sleep(1000);
			driver.findElementByXPath("//XCUIElementTypeSwitch[@visible='true' and @name='Bluetooth']").click(); // switch to bluetooth
		}
		
		
		
	}
	public static boolean isBluetoothEnabled()
    {
		//bluetoothPage bl=new bluetoothPage(driver);
		return driver.findElementByXPath("//XCUIElementTypeSwitch[@visible='true' and @name='Bluetooth']").getAttribute("value").equals("1"); // return the existing condition
    }
	
		 
}