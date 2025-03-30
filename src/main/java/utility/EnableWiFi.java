package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.bluetoothPage;

public class EnableWiFi {
	static int visited=0;
	private static IOSDriver<?> driver;   // declare local driver
	public EnableWiFi(IOSDriver<?> driver)
	{
		EnableWiFi.driver=driver;   // assigned the driver to local driver
	}
	
		
	
	public static void enable(boolean expectedWiFiSTATUS) throws InterruptedException
	{
		
		 driver.findElementByXPath("//XCUIElementTypeCell[@visible='true' and @name='Wi-Fi']").click();
		 Thread.sleep(5000);
		
		if(isWiFiEnabled()!=expectedWiFiSTATUS)
		{
			System.out.println("Wifi enable status is "+expectedWiFiSTATUS);
			Thread.sleep(2000);
			driver.findElementByXPath("//XCUIElementTypeSwitch[@visible='true' and @name='Wi‑Fi']").click(); // switch to bluetooth	
		}
	}
	public static boolean isWiFiEnabled() throws InterruptedException
	{
		return driver.findElementByXPath("//XCUIElementTypeSwitch[@visible='true' and @name='Wi‑Fi']").getAttribute("value").equals("1"); // return the existing condition
	}
	
		
}