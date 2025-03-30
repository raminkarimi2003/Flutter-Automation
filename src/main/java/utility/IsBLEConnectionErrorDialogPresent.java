package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.bluetoothPage;
import pageObject.connectionAlert;
import pageObject.locationAlert;

public class IsBLEConnectionErrorDialogPresent  {
		
	
//	public static void Check(IOSDriver<WebElement>driver) throws InterruptedException
//	{
//		
//        connectionAlert conn=new connectionAlert(driver);         // Initialize the class with driver and  create instance of it
//        boolean flag=conn.ConnectionAlert().size()>0; // check if the location alert dialog is present
//        //boolean error=conn.ConnectionError().size()>0;
//        if(flag) 
//          {
//        	Thread.sleep(2000);
//        	String locationName=conn.Cancel().getText(); // get the text for the element
//        	System.out.println("");
//        	System.out.println(locationName);
//        	new Coordinates(driver);                       // initialize the class with driver
//            Coordinates.Permission(locationName);          // tab on the element by its relative XY
//          }

//	}
	public static void Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        connectionAlert con=new connectionAlert(driver);         // Initialize the class with driver and  create instance of it
        boolean flag=con.ConnectionError().size()>0;
        System.out.println("the flag condition is "+flag);
       if(flag) 
          {
        	con.Retry.click();
          }    

	}
	
}  