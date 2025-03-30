package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.camerPermissionPage;

public class IsCameraPermissionDialogPresent  {
		
	
	public static boolean Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  		// implicit time out
		camerPermissionPage cp=new camerPermissionPage(driver);
		boolean flag=cp.Access().size()>0;
		System.out.println("Camera permission "+flag);
        if(flag) 
        {
        	cp.OK().click();  // permit the camera
        }	
		return flag;
	}
}  



