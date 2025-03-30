package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.camerPermissionPage;
import pageObject.checkEquipmentPage;
import pageObject.conditionEquipmentPage;

public class IsConditionEquipmentDialogPresent  {
		
	
	public static boolean Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  		// implicit time out
		conditionEquipmentPage cp=new conditionEquipmentPage(driver);
		boolean flag=cp.Condition().size()>0;
		System.out.println("Condition Equipment Dialog "+flag);   // confirm pr-check is correct and can be submitted
        if(flag) 
        {
        	cp.Agree().click();  // permit the camera
        }	
		return flag;
	}
}  



