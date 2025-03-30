package utility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.ios.IOSDriver;
import pageObject.drivePage;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;


public class LicensePlate  {
		
	
	public static void Check(IOSDriver<WebElement>driver) throws InterruptedException
	{
		 drivePage drive=new drivePage(driver);
		 String driveID=drive.DriveID.getText().toLowerCase().substring(4);
		 Thread.sleep(1000);
		 System.out.println("The License plate ID is "+driveID);
		 drive.Equipment.click();   // tab on equipment icon
		 Thread.sleep(1000);
		 equipmentDetailsPage eq=new equipmentDetailsPage(driver);
		 String rentedEquipmentID=eq.equipmentID.getText().toLowerCase().substring(3);
		 System.out.println("The License plate ID is "+rentedEquipmentID);
		 Assert.assertEquals(driveID, rentedEquipmentID); // assert
		 Thread.sleep(5000);
		 UseEquipment.use(driver, "Use Equipment");   // use equipment again to navigate back to drive tab

	}
} 