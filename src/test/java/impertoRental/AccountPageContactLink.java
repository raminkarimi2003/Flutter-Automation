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

import com.google.common.collect.ImmutableMap;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.StopWatch;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;
import pageObject.accountPage;
import pageObject.bluetoothPage;
import pageObject.checkEquipmentPage;
import pageObject.contactEquipmentPage;
import pageObject.drivePage;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import pageObject.finishPage;
import pageObject.helloPage;
import pageObject.impertoBookingPage;
import pageObject.impertoLoginPage;
import pageObject.locationAlert;
import pageObject.loginPage;
import pageObject.logoPage;
import pageObject.notificationPage;
import pageObject.projectPage;
import resources.BaseIOSTest;
import resources.BaseSeleniumTest;
import utility.Action;
import utility.Bluetooth;
import utility.CheckBox;
import utility.Coordinates;
import utility.ImpertoBookingCancelation;
import utility.ImpertoLogin;
import utility.IsBlutoothDialogPresent;
import utility.IsLocationAlertPagePresent;
import utility.IsNotificationDialogPresent;
//import utility.IsLocationAlertPagePresent;
import utility.Login; 
import utility.Logout;
import utility.NonStaticDropDown;
import utility.Notification;
import utility.ScrollToElement;
import utility.ScrollToORG;
import utility.ScrollToText;
import utility.TakePhoto;
import utility.getAssetLocation;
import utility.loginSteps;
import utility.SelectAsset;
import static io.appium.java_client.touch.offset.PointOption.point;


@Listeners(resources.Listeners.class)
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// The purpose of this test case is to assert that the telephone No. in Help line is correct
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////
public class AccountPageContactLink extends BaseIOSTest{

	@Test(groups={"TestGroup1"},enabled=false)
	public void AccounPagetContactLink_Reset() throws InterruptedException, IOException
	{	
	    service=startServer();  // start server
	    BaseIOSTest.Credential();  // invoke method to access username and/or password properties 
	    
		// TODO Auto-generated method stub
		IOSDriver<WebElement> driver= DesiredCapabilities("ImpertoApp"); // call DesiredCapabilities method and assign it driver object
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	    System.out.print("Crash status is "+BaseIOSTest.crash);
	    System.out.print("\n'");
		IsNotificationDialogPresent.Check(driver);
		IsBlutoothDialogPresent.Check(driver);  // check to see if there is bluetooth dialog, and if there is OK that
		logoPage lp=new logoPage(driver);
	    lp.Skip.click();
	    if(!BaseIOSTest.crash)  // check to see if there were previous crash in the previous test case run
	    {
	      new loginSteps(driver);
		  loginSteps.steps();   // this method will perform logging steps to fill in user name Email and password
	    }  
        Thread.sleep(3000);
        new ScrollToORG(driver);
        ScrollToORG.scroll("TEST(COM.IMPERTO.RAMISHARE)/FlutterAutomationCustomer/Supervisor"); // Scroll and select your ORGOrganization 
        projectPage pp=new projectPage(driver);
	    pp.Done.click();   // login to your selected project
	    IsLocationAlertPagePresent.Check(driver);
	    equipmentPage eq=new equipmentPage(driver);
	    eq.account.click();      // click on Account tab	    
	    new ScrollToText(driver);
	    ScrollToText.scroll("To amend your details please contact helpline");  // scroll to text
        Thread.sleep(2000);
	    accountPage ap=new accountPage(driver);
	    ap.CallForHelpLink.click();       // click on 'call for help' link
		Assert.assertEquals(ap.CallNumber.getText(),"2064227082");  // Assert the call number is as expected
	    ap.ConfirmCallDlg.click(); 
		Logout.App(driver);
		stopServer(); 

	}	
	
	@Test
	public void InitializeChromeDriver() throws IOException, InterruptedException {
		

	       BaseIOSTest.InitializeSeleniumDriver();   // call the method to initialize Chrome browser
	       ImpertoLogin.signIn(BaseIOSTest.seleniumdriver);

	}
}
