package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.camerPermissionPage;
import pageObject.checkEquipmentAbandonFormPage;
import pageObject.checkEquipmentConfirmationPage;

public class IsCheckEquipmentConfirmationDialogPresent  {
		
	
	public static boolean Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  		// implicit time out
		checkEquipmentConfirmationPage cp=new checkEquipmentConfirmationPage(driver);
		boolean flag=cp.ConfirmDialog().size()>0;
		System.out.println("Confirm Dialog "+flag);
        if(flag) 
        {
        	cp.Agree().click();  // permit the camera
        }	
		return flag;
	}
}  



