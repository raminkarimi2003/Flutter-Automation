package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.actionFailedAlert;
import pageObject.connectToEquipmentPage;
import pageObject.equipmentDetailsPage;
import pageObject.locationAlert;

public class IsActionFailedAlertPresent  {
		
	
	public static void check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		boolean actionFailed=false;
		do
		  {
			actionFailed=false;                                  // start with false pre-condition
            actionFailedAlert la=new actionFailedAlert(driver);         // Initialize the class with driver and  create instance of it
            boolean flag=la.Actionfailed().size()>0; // check if the location alert dialog is present
            if(flag) 
            {
              actionFailed=true; 	
        	  String locationName=la.oK.getText(); // get the text for the element
        	  new Coordinates(driver);                       // initialize the class with driver
              Coordinates.Permission(locationName);          // tab on the element by its relative XY
              connectToEquipmentPage ce=new connectToEquipmentPage(driver);
              //boolean ConnectEquipmentPage=ce.connect.size()>0;  // check  if the connect to equipment page present
             //if(ConnectEquipmentPage)
             // {
                ce.backArrow.click();     // click on back arrow
                equipmentDetailsPage details=new equipmentDetailsPage(driver);
    	   	    details.useEquipment.click();                  // use equipment
    	    	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);  		// implicit time out
             // }
            } 
		  } // end of do while
          while(actionFailed);
		}
}  