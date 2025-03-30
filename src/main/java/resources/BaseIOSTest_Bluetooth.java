package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


// System.getProperty("user.dir") get the working directory where program was launched from
// System.gertProperty(" ") this method get the system property indicated by specific key
public class BaseIOSTest_Bluetooth {
	
	public  static AppiumDriverLocalService service; // make variable public, so it is accessible from outside the class
	public static IOSDriver<WebElement> driver;
	
	public AppiumDriverLocalService startServer() throws InterruptedException
	{
		Thread.sleep(5000);
		boolean flag=checkIfServerIsRunnning(4723);
		System.out.println("Server runing status is "+flag);
		if(!flag)
		{
		service = AppiumDriverLocalService // use AppiumDriver Local Service class to access buildService method for starting default server using 4723 port
		.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
		.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723));
		service.start(); // call to start server
		}
		return service;
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

@BeforeTest
public void KillAllNodes() throws IOException 
{
	Runtime.getRuntime().exec("kill -15$(lsof -Pi:4723"); // kill all the nodes and clear tasks
}

  
	public static IOSDriver<WebElement> DesiredCapabilities() throws IOException {
		
			   
		
		// TODO Auto-generated method stub
		// Tell appium Platform version( that automate the app), Device name , automation_name and app name
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.0.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME ,"iPhone");
		// Automation  framework provided by IOS : IOS_XCUI_Test
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, "500000"); // Launch time out delay for the app in ms (50)
		// Delay for command execution timeout(like click, scroll)
		capabilities.setCapability("commandTimeouts", "750000");
		
		
	    capabilities.setCapability("simpleIsVisibleCheck","true");
		capabilities.setCapability("udid", "00008030-001241C821F2402E");  // device udid(Unique Device Identifier)
		capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,"com.apple.Preferences");
		
		  //capabilities.setCapability("noReset", false);
		// path to appium server ( and the capability object that have to be re-directed to the ios automation)
	    driver =new IOSDriver<>(new URL("http://localhost:4723/wd/hub"),capabilities);
		return driver;

 }
	
	
	
	@AfterTest
	public void  stopServer()
	{
		service.stop();
	}
}