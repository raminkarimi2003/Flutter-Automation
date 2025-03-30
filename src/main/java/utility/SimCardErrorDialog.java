package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.airplaneModePage;
import pageObject.locationAlert;

public class SimCardErrorDialog  {
		
	
	public static void Close(IOSDriver<WebElement>driver) throws InterruptedException
	{
		
		
		airplaneModePage ap=new airplaneModePage(driver);
	    boolean flag=ap.sim.size()>0;  // check if alert dialog present
	    if (flag){
	    	 String OKText=ap.OK.getText();
	    	 new Coordinates(driver); // get the. coordinate of text
	    	 Coordinates.Permission(OKText); // dismiss the dialog by the help of coordinate
	    }         

	}
}