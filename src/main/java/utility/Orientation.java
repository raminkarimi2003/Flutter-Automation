package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.checkEquipmentPage;
import resources.BaseIOSTest;

public class Orientation extends BaseIOSTest{
  
 
 public static void set(IOSDriver<WebElement>driver, String orient) throws InterruptedException{


 if (orient.equalsIgnoreCase("landscape"))  // adjust the orientation for the photo to be taken
 {
	 try {
	   driver.rotate(ScreenOrientation.LANDSCAPE);
	  } catch (WebDriverException ignore) {
	    //Ignore the exception
	}
 }
 else
	 try {
		   driver.rotate(ScreenOrientation.PORTRAIT);  
		  } catch (WebDriverException ignore) {
		    //Ignore the exception
		}
	 

 }
}
