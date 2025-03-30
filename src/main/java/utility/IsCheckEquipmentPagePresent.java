package utility;

import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.checkEquipmentPage;
import pageObject.locationAlert;

public class IsCheckEquipmentPagePresent  {
		
	
	public static boolean Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(58, TimeUnit.SECONDS);  		// implicit time out
		Thread.sleep(50000);
		checkEquipmentPage cq=new checkEquipmentPage(driver);
		boolean flag1=cq.checkEquipment.size()>0;          // check to see if check equipment page exist
		System.out.println("Equipment Page is "+flag1);
        if(flag1) 
        {
        	Thread.sleep(2000);
        
        	cq.Continue.click();  
        }	
		return flag1;
	}
	
//	public static boolean Check(IOSDriver<WebElement>driver,boolean acceptPhotoBox) throws InterruptedException
//	{
//		driver.manage().timeouts().implicitlyWait(58, TimeUnit.SECONDS);  		// implicit time out
//		Thread.sleep(58000);
//		checkEquipmentPage cq=new checkEquipmentPage(driver);
//		boolean flag=cq.checkEquipment.size()>0;          // check to see if check equipment page exist
//		System.out.println("Equipment Page is "+flag);
//        if(flag&&acceptPhotoBox) 
//        {
//        	Thread.sleep(10000);
//        	SelectAsset.ScrollDownTo(driver,"Cabin photo");
//        	//SelectAsset.ScrollDownTo(driver,"I confirm that the photos and descriptions above are accurate");
//        	cq.checkbox.click();    // accept current photos and bypass taking photos
//        	cq.Continue.click();  
//        }	
//		return flag;
//	}
}  






