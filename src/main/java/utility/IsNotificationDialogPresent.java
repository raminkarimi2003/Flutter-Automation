package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.bluetoothPage;
import pageObject.checkEquipmentPage;
import pageObject.locationAlert;
import pageObject.notificationPage;

public class IsNotificationDialogPresent  {
		
	
	public static boolean Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  		// implicit time out
		notificationPage np=new notificationPage(driver);
		boolean flag=np.push.size()>0;
		System.out.println("Notification dialog "+flag);
        if(flag) 
        {
        	np.Allow().click();
        }	
		return flag;
	}
}  



