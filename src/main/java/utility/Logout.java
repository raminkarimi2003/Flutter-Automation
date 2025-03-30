package utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.accountPage;
import pageObject.bluetoothPage;
import pageObject.equipmentPage;
import pageObject.loginPage;
import pageObject.logoPage;
import resources.BaseIOSTest;

public class Logout  {
		
	
	public static void App(IOSDriver<WebElement>driver) throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		accountPage a=new accountPage(driver);
		boolean flag=a.accountInformation.size()>0;
		if(!flag)
			{equipmentPage ep=new equipmentPage(driver);
			ep.account.click();
			}
		
		a.LogOut.click();
		Thread.sleep(1000);
	    a.ConfirmLogOut.click();
	}
} 