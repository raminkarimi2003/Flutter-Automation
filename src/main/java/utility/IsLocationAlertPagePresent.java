package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.locationAlert;

public class IsLocationAlertPagePresent  {
		
	
	public static void Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  		// implicit time out
        locationAlert la=new locationAlert(driver);         // Initialize the class with driver and  create instance of it
        boolean flag=la.AlertPresent().size()>0; // check if the location alert dialog is present
        if(flag) 
          {
        	la.allowUsing.click();
          }
//        else
//         {
//          boolean flag1=la.AllowRental().size()>0;  // check to see if Rental location Dialog present
//          if(flag1)
//          {
//        	String locationName=la.ChangeToAllow().getText(); // get the text for the element
//        	new Coordinates(driver);                       // initialize the class with driver
//            Coordinates.Permission(locationName);          // tab on the element by its relative XY
//          }
//        	
//         
//         }
	}
}  