package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.camerPermissionPage;
import pageObject.checkEquipmentAbandonFormPage;

public class IsCheckEquipmentAbandonFormPresent  {
		
	
	public static boolean Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  		// implicit time out
		checkEquipmentAbandonFormPage cp=new checkEquipmentAbandonFormPage(driver);
		boolean flag=cp.AbandonDialog().size()>0;
		System.out.println("Abandon Dialog "+flag);
        if(flag) 
        {
        	cp.Abandon().click();  // permit the camera
        }	
		return flag;
	}
}  



