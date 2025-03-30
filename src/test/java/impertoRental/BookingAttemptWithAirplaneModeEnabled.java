package impertoRental;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import pageObject.drivePage;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import pageObject.finishPage;
import pageObject.helloPage;
import pageObject.internetAlertPage;
import pageObject.loginPage;
import pageObject.logoPage;
import pageObject.projectPage;
import resources.BaseIOSTest;
import resources.BaseIOSTest_NoReset;
import utility.Bluetooth;
import utility.CheckBox;
import utility.Coordinates;
import utility.EnableAirplane;
import utility.EnableBluetooth;
import utility.EnableWiFi;
import utility.EndRental;
import utility.Finish;
import utility.IsActionFailedAlertPresent;
import utility.IsBlutoothDialogPresent;
import utility.IsCameraPermissionDialogPresent;
import utility.IsCheckEquipmentPagePresent;
import utility.IsConditionEquipmentDialogPresent;
import utility.IsInternetConnectionAlertPresent;
import utility.IsLocationAlertPagePresent;
import utility.IsNotificationDialogPresent;
import utility.Login;
import utility.Logout;
import utility.LongPress;
import utility.Notification;
import utility.Orientation;
import utility.ScrollToElement;
import utility.ScrollToORG;
import utility.ScrollToText;
import utility.SelectAsset;
import utility.SelectAssetForRent;
import utility.StartRental;
import utility.TakePhoto;
import utility.UseEquipment;
import utility.isSimCardErrorDialogPresent;
import utility.isiPhonsettingsMainPagePresent;
import utility.loginSteps;


@Listeners(resources.Listeners.class)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// The purpose of this test case is to demonstrate the the app will gracefully handle booking with Enabled Airplane
// Mode and after turning it off, The App continue its normal operation.
// 
// Note: If when you turned ON Airplane mode on your iPhone, WIFI did not turn OFF automatically , that means, you
// have previously turned ON WIFI, when you were already on Airplane Mode, so the device remember. To remedy 
// situation( ie. WIFI goes off when Airplane Mode is ON), follow this instruction
// 1) While Airplane Mode ON(Switch ie. Airplane Mode switched ON)   2)Switch  WIFI OFF So the deevice remembers now,
// When Airplane Mode is on, WIFI should be off and vice versa
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class BookingAttemptWithAirplaneModeEnabled extends BaseIOSTest{
 
	@Test(groups={"TestGroup2"})
	public void bookingAttemptWithEnabledAirplaneMode_NoReset() throws InterruptedException, IOException
	{		
		service=startServer();  // start server
		BaseIOSTest.Credential();  // invoke method to access username and/or password properties
		IOSDriver<WebElement> standard_driver= BaseIOSTest.DesiredCapabilities("ImpertoApp"); // install app and reset cached data(through standard driver)
		IsNotificationDialogPresent.Check(standard_driver);
		IsBlutoothDialogPresent.Check(standard_driver);  // check to see if there is bluetooth dialog, and if there is OK that
		IOSDriver<WebElement> driver= DesiredCapabilities("ImpertoApp"); // call DesiredCapabilities method(with No_Reset driver) and assign it driver object
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
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
		Thread.sleep(1000);
		equipmentPage eq=new equipmentPage(driver);
		eq.AvailableForRent().click();  // click on 'Available for Rent'
		Thread.sleep(5000);
		SelectAssetForRent.ScrollDownTo(driver,"BACKHOE"); // scroll down to asset ("BACKHOE") and rent it
		
		
		// launch iPhone setting
		HashMap<String,Object>args=new HashMap<>();
		args.put("bundleId","com.apple.Preferences");
		driver.executeScript("mobile: launchApp", args);
					
		new isiPhonsettingsMainPagePresent(driver);
		isiPhonsettingsMainPagePresent.check();     //check to see if you are on main settings(Phone)
		new EnableAirplane(driver);
		EnableAirplane.enable(true);   // switch on Airplane Mode
		driver.closeApp();   
		driver.launchApp();
        Thread.sleep(5000);
		SelectAssetForRent.ScrollDownTo(driver,"BACKHOE"); // scroll down to asset ("BACKHOE") and rent it
		new ScrollToText(driver);
		ScrollToText.scroll("Start Rental");   // scroll to rental button
		StartRental.rent(driver,"Start Rental","NoInternet");  // rent with NO Internet
		internetAlertPage iap=new internetAlertPage(driver);
        Assert.assertEquals(iap.noInternetConnection.getText(),"No Internet Connection");  // assertion that the statement is true
        IsInternetConnectionAlertPresent.Check(driver);
        driver.closeApp();		
		driver.launchApp();
        Thread.sleep(1000);
        driver.activateApp("com.apple.Preferences");
        new isiPhonsettingsMainPagePresent(driver);
		isiPhonsettingsMainPagePresent.check();     //check to see if you are on main settings(Phone)
		new EnableAirplane(driver);
	    EnableAirplane.enable(false);   // switch off Airplane Mode
	    new isSimCardErrorDialogPresent(driver);
	    isSimCardErrorDialogPresent.check();    // check to see if there is sim card error
		Thread.sleep(2000);
        driver.closeApp();
        driver.launchApp();   // launch the first app from where it was left off
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
	    drive.locked.click(); // lock the equipment    
	    EndRental.end(driver);
        TakePhoto.photo(driver,"BACKHOE");
        CheckBox.check();
        Thread.sleep(7000);
        Finish.verify(driver);
        Logout.App(driver); 
		stopServer(); 
	}	
}
