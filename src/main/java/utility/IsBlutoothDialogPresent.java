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

public class IsBlutoothDialogPresent  {
		
	
	public static boolean Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  		// implicit time out
		bluetoothPage bl=new bluetoothPage(driver);
		boolean flag=bl.Permission().size()>0;          // check to see if check bluetooth page exist
		System.out.println("Bluetooth dialog "+flag);
        if(flag) 
        {
        	bl.ok.click();
        }	
		return flag;
	}
	
/*	public static boolean Check(IOSDriver<WebElement>driver,boolean acceptPhotoBox) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(58, TimeUnit.SECONDS);  		// implicit time out
		Thread.sleep(58000);
		checkEquipmentPage cq=new checkEquipmentPage(driver);
		boolean flag=cq.checkEquipment.size()>0;          // check to see if check equipment page exist
		System.out.println("Equipment Page is "+flag);
        if(flag&&acceptPhotoBox) 
        {
        	Thread.sleep(10000);
        	SelectAsset.ScrollDownTo(driver,"Cabin photo");
        	//SelectAsset.ScrollDownTo(driver,"I confirm that the photos and descriptions above are accurate");
        	cq.checkbox.click();    // accept current photos and bypass taking photos
        	cq.Continue.click();  
        }	
		return flag;
	}*/
}  






