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
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.SessionId;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObject.accountPage;
import pageObject.bluetoothPage;
import pageObject.checkEquipmentPage;
import pageObject.connectToEquipmentPage;
import pageObject.drivePage;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import pageObject.finishPage;
import pageObject.germanLibPage;
import pageObject.helloPage;
import pageObject.iPhoneLanguagePage;
import pageObject.locationAlert;
import pageObject.loginPage;
import pageObject.logoPage;
import pageObject.notificationPage;
import pageObject.projectPage;
import pageObject.rentedEquipmentPage;
import resources.BaseIOSTest;
import resources.BaseIOSTest_Bluetooth;
import utility.Bluetooth;
import utility.CheckBox;
import utility.Coordinates;
import utility.EnableBluetooth;
import utility.EnableWiFi;
import utility.EndRental;
import utility.Finish;
import utility.IsActionFailedAlertPresent;
import utility.IsBlutoothDialogPresent;
import utility.IsCheckEquipmentPagePresent;
import utility.IsLocationAlertPagePresent;
import utility.IsNotificationDialogPresent;
import utility.Login;
import utility.Logout;
import utility.Notification;
import utility.ScrollToElement;
import utility.ScrollToORG;
import utility.ScrollToText;
import utility.TakePhoto;
import utility.getAssetLocation;
import utility.isiPhonsettingsMainPagePresent;
import utility.SelectAsset;
import utility.StartRental;
import resources.BaseIOSTest_NoReset;

@Listeners(resources.Listeners.class)
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// The purpose of this test case is to demonstrate the app has the ability to switch from the original 
// language to another language while app closed.
// 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class ChangeLanguageWhileAppClosed extends BaseIOSTest{
 
	@Test(groups={"TestGroup2"})
	public void LanguageChangedWithClosedApp_Reset() throws InterruptedException, IOException
	{		
		service=startServer();  // start server
		BaseIOSTest.Credential();  // invoke method to access username and/or password properties
		IOSDriver<WebElement> driver= DesiredCapabilities("ImpertoApp"); // call DesiredCapabilities method(with No_Reset driver) and assign it driver object
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		IsNotificationDialogPresent.Check(driver);
		IsBlutoothDialogPresent.Check(driver);  // check to see if there is bluetooth dialog, and if there is OK that
		logoPage lp=new logoPage(driver);
		lp.Skip.click();
		helloPage hl=new helloPage(driver);
		hl.englishLanguage.click();  // open English setting tab
		hl.deutschLanguage.click();  // switch to German
		germanLibPage gr=new germanLibPage(driver);
		gr.login.click();
		new Login(driver);
        Login.App(op_username,password);   // this method login to the app (through Email & password)
	    new ScrollToORG(driver);
        Thread.sleep(1000);
	    ScrollToORG.scroll("TEST(COM.IMPERTO.RAMISHARE)/FlutterAutomationCustomer/Buchungs-Supervisor"); // Scroll and select your ORG
		gr.Done.click();   // login to your selected project
		IsLocationAlertPagePresent.Check(driver);
        Assert.assertEquals(gr.textToCompare.getText(), "Siehe Maschine Zur Miete verfügbar");    // Assert that that the wording has been translated correctly
		gr.account.click(); //click on account tab
		gr.logOut.click(); //logout
		gr.OK.click(); // conform logout
        stopServer();
	}	
} 
