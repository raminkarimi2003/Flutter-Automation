package impertoRental;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.springframework.util.StopWatch;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import pageObject.accountPage;
import pageObject.bluetoothPage;
import pageObject.checkEquipmentPage;
import pageObject.contactEquipmentPage;
import pageObject.drivePage;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import pageObject.finishPage;
import pageObject.helloPage;
import pageObject.locationAlert;
import pageObject.loginPage;
import pageObject.logoPage;
import pageObject.notificationPage;
import pageObject.projectPage;
import pageObject.rentedEquipmentPage;
import resources.BaseIOSTest;
import utility.Bluetooth;
import utility.CheckBox;
import utility.Coordinates;
import utility.EndRental;
import utility.Finish;
import utility.IsActionFailedAlertPresent;
import utility.IsBLEConnectionErrorDialogPresent;
import utility.IsBlutoothDialogPresent;
import utility.IsCameraPermissionDialogPresent;
import utility.IsCheckEquipmentPagePresent;
import utility.IsConditionEquipmentDialogPresent;
import utility.IsLocationAlertPagePresent;
import utility.IsNotificationDialogPresent;
import utility.ScrollToElement;
import utility.ScrollToORG;
import utility.ScrollToText;
import utility.SelectAsset;
import utility.SelectAssetForRent;
import utility.StartRental;
import utility.TakePhoto;
import utility.UseEquipment;
import utility.getAssetLocation;
import utility.loginSteps;
import utility.LicensePlate;
import utility.Login;
import utility.Logout;
import utility.Notification;
import utility.Orientation;
@Listeners(resources.Listeners.class)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
// The purpose of this test case is to verify that the name of equipment in drive screen is the same as name 
// of equipment under the rented tab. (OHW-2197)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class EquipmentNameAssertion extends BaseIOSTest{
 
	@Test(groups={"TestGroup3"})
	public void equipmentNameAssertion_Reset() throws InterruptedException, IOException
	{
		service=startServer();  // start server
	    BaseIOSTest.Credential();  // invoke method to access username and/or password properties
		// TODO Auto-generated method stub
		IOSDriver<WebElement> driver= DesiredCapabilities("ImpertoApp"); // call DesiredCapabilities method and assign it driver object
		IsNotificationDialogPresent.Check(driver);
		IsBlutoothDialogPresent.Check(driver);  // check to see if there is bluetooth dialog, and if there is OK that
		logoPage lp=new logoPage(driver);
		lp.Skip.click();
		if(!BaseIOSTest.crash)   // check to see if there were previous crash in the previous test case run
	    {
		  new loginSteps(driver);
		  loginSteps.steps();   // this method will perform logging steps to fill in user name Email and password
	    }  
	    new ScrollToORG(driver);
	    Thread.sleep(1000);
	    ScrollToORG.scroll("TEST(COM.IMPERTO.RAMISHARE)/FlutterAutomationCustomer/Booking Supervisor"); // Scroll and select your ORG
	    projectPage pp=new projectPage(driver);
		pp.Done.click();   // login to your selected project
		IsLocationAlertPagePresent.Check(driver);
		equipmentPage eq=new equipmentPage(driver);
		eq.AvailableForRent().click();  // click on 'Available for Rent'
		Thread.sleep(5000);
		SelectAssetForRent.ScrollDownTo(driver,"BACKHOE"); // scroll down to asset ("BACKHOE") and rent it
		new ScrollToText(driver);
		ScrollToText.scroll("Start Rental");   // scroll to rental button
        StartRental.rent(driver,"Start Rental");  // rent
        ScrollToText.scroll("Use Equipment");   // scroll to "Use Equipment" button
        UseEquipment.use(driver, "Use Equipment");
        IsCameraPermissionDialogPresent.Check(driver);       // check to see if camera permission available and if it exist permit it
        Orientation.set(driver, "portrait");                 // set the orientation for photo to portrait
        TakePhoto.photo(driver,"BACKHOE");
        new CheckBox(driver);
        CheckBox.check();    // tick the check list
        IsConditionEquipmentDialogPresent.Check(driver);     // confirm pre-check submission
	    drivePage drive=new drivePage(driver);
	    String DriveName=  drive.assetInDrive.getText();// get the  actual name of asset in drive
	    eq.Equipment.click();    // go to equipment pag
	    Thread.sleep(3000);
	    equipmentDetailsPage rentedAsset=new equipmentDetailsPage(driver);
	    String RentedName=rentedAsset.RentedAsset().getText();    // get the name of Asset under Equipment Detail page
	    Assert.assertEquals(DriveName,RentedName);   // Assert name of Asset under drive and equipment details page
	    UseEquipment.use(driver, "Use Equipment");   // now Use Equipment again to navigate back to drive 
	    IsBLEConnectionErrorDialogPresent.Check(driver); // check to see if BLE Connection Dialog present
	    Thread.sleep(3000);
	    drive.locked.click(); // lock the equipment
	    EndRental.end(driver);
        TakePhoto.photo(driver,"BACKHOE");
        new CheckBox(driver);
        CheckBox.check();
        Finish.verify(driver);
        Logout.App(driver); 
        stopServer();
	}	
}
