package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.camerPermissionPage;
import pageObject.endRentalConfirmationPage;

public class IsEndRentalConfirmationDialogPresent  {
		
	
	public static boolean Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  		// implicit time out
		endRentalConfirmationPage cp=new endRentalConfirmationPage(driver);
		boolean flag=cp.EndRentalAlert().size()>0;
		System.out.println("End Rental confirmation "+flag);
        if(flag) 
        {
        	cp.endRentalConfirmation.click();  // confirm end rental
        }	
		return flag;
	}
}  



