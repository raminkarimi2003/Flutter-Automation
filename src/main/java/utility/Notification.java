package utility;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.notificationPage;

public class Notification  {
		
	
	public static void Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		
		notificationPage np=new notificationPage(driver);
		boolean flag=np.push.size()>0;
		if(flag)
		{
		 np.Allow().click();  // Allow the notification
		} 
	}
}