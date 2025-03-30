package utility;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;

public class getAssetLocation {

	private static IOSDriver<?> driver;   // declare local driver
	public getAssetLocation(IOSDriver<?> driver)
	{
		getAssetLocation.driver=driver;   // assigned the driver to local driver of the class
	}
	
	
    public static int YCoordinate(String asset) throws InterruptedException 
    {
    	//WebElement desiredAsset=driver.findElementByAccessibilityId(asset);
    	WebElement desiredAsset=driver.findElementByXPath("//*[contains(normalize-space(@name),'"+asset+"')]"); 
    	Point PointY=desiredAsset.getLocation();
    	int gety=PointY.getY();   // get the Y coordinate
    	return gety;
        	 
    }
    	
}