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
public class BaseIOSTest_iPhoneSettings {
	public String InitialAsset="SCISSOR LIFT ES2632 DC";
	public final double START_X=0.5;
	public final double START_Y=0.65;
	public final double END_X=0.5;
	public final double END_Y=0.27;
	public final int RENT_X=130;
	public final int RENT_Y=150;
	public final static int USE_X=130;
	public final static int USE_Y=150;
	public static String op_username;
	public static String tech_username;
	public static String password;
	public static String asset;
	public static String asset2;
	
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

   public static void Credential() throws IOException
   {
	   FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/global.properties"); // FileInputStream will give you access(read) to the file through java object
		Properties prop=new Properties(); // use properties class to read property value 
		prop.load(fis); // loading file stream for the prop object
	    op_username=prop.getProperty("op_username");
	    tech_username=prop.getProperty("tech_username");
		password=prop.getProperty("password");
		asset=prop.getProperty("asset"); // get the asset from Global property
		asset2=prop.getProperty("asset2"); // get the asset from Global property
   }
	
	public static IOSDriver<WebElement> DesiredCapabilities(String appName) throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/global.properties"); // FileInputStream will give you access(read) to the file through java object
		Properties prop=new Properties(); // use properties class to read property value 
		prop.load(fis); // loading the file from input stream
		String version=prop.getProperty("version");  // retrieve the version value
		String udid=prop.getProperty("udid");        // retrieve UDID
		String xcodeorgid=prop.getProperty("xcodeorgid"); 
	   
		
		// TODO Auto-generated method stub
		// Tell appium Platform version( that automate the app), Device name , automation_name and app name
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME ,"iPhone");
		// Automation  framework provided by IOS : IOS_XCUI_Test
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		
		// declare the app to deploy on the device
	    capabilities.setCapability(MobileCapabilityType.APP, "com.apple.Preferences");
		capabilities.setCapability("xcodeOrgId",xcodeorgid);  // Team ID
		capabilities.setCapability("xcodeSigningId","iPhone Developer");
		capabilities.setCapability("udid", udid);  // device udid(Unique Device Identifier)
		capabilities.setCapability("noReset",true);
		capabilities.setCapability("fullReset",false);
		//capabilities.setCapability("shouldTerminateApp",false);
		//capabilities.setCapability("resetOnSessionStartOnly", false);
		//capabilities.setCapability("updatedWDABundleId","com.irdetosecurity.keystone.clr.zeppelin.internal");
		// path to appium server ( and the capability object that have to be re-directed to the ios automation)
	    driver =new IOSDriver<>(new URL("http://localhost:4723/wd/hub"),capabilities);
		return driver;

 }
	
	public static void getScreenShot(String name) throws IOException
	{
		
	 try {
		  // to create reference to screenshot
		  TakesScreenshot screenshot=(TakesScreenshot)driver;
		  //call method to capture screenshot
		  File src=screenshot.getScreenshotAs(OutputType.FILE);
		  // copy file object to specific location
		  FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"/FailedSnapshots/"+name+".png"));
		  System.out.println("captured screenshot due to failed operation");
	     }catch (Exception e) {
	    	 System.out.println("Exception while taking screenshot "+e.getMessage());
	        }
	}
	
	@AfterTest
	public void  stopServer()
	{
		service.stop();
	}
}