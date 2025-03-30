package utility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import resources.BaseIOSTest;


public class availableEquipmentLink extends BaseIOSTest {
	private static IOSDriver<WebElement> driver;   // declare local driver
	public availableEquipmentLink(IOSDriver<WebElement> driver)
	{
		availableEquipmentLink.driver=driver;   // assigned the driver to local driver
	}
	

	public static void verify(String asset) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		equipmentPage eq=new equipmentPage(driver); 
		eq.equipmentLink.click(); 
		SelectAssetForRent.ScrollDownTo(driver,asset); // scroll down to asset ("BACKHOE") and rent it
		IsLocationAlertPagePresent.Check(driver);
		boolean rightAssetSelected=driver.findElementsByXPath("//*[contains(normalize-space(@name),'"+asset+"')]").size()>0;
		Assert.assertTrue(rightAssetSelected); // asset that the right asset selected
		equipmentDetailsPage eqd=new equipmentDetailsPage(driver);
		eqd.backArrow.click();
	}	
}