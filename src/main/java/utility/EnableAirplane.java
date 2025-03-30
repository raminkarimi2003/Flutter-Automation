package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.bluetoothPage;

public class EnableAirplane {
	static int visited=0;
	private static IOSDriver<?> driver;   // declare local driver
	public EnableAirplane(IOSDriver<?> driver)
	{
		EnableAirplane.driver=driver;   // assigned the driver to local driver
	}
	
		
	
	public static void enable(boolean expectedAirplaneSTATUS) throws InterruptedException
	{
		
		if(isAirplaneEnabled()!=expectedAirplaneSTATUS)
		{
			System.out.println("Airplane enable status is "+expectedAirplaneSTATUS);
			Thread.sleep(4000);
			driver.findElementByXPath("//XCUIElementTypeSwitch[@visible='true' and @name='Airplane Mode']").click(); // switch to Airplane	
		}
	}
	public static boolean isAirplaneEnabled()
	{
		return driver.findElementByXPath("//XCUIElementTypeSwitch[@visible='true' and @name='Airplane Mode']").getAttribute("value").equals("1"); // return the existing condition
	}
	
		
}