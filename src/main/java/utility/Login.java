package utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.bluetoothPage;
import pageObject.loginPage;
import pageObject.logoPage;
import resources.BaseIOSTest;

public class Login{
	private static IOSDriver<?> driver;   // declare local driver
	public Login(IOSDriver<?> driver)
	{
		Login.driver=driver;   // assigned the driver to local driver of the class
	}
		
	public static void App(String username,String password) throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        loginPage logp=new loginPage(driver);       
        logp.getuserName().sendKeys(username);    // enter user
        logp.password.sendKeys(password);         // enter password
        Thread.sleep(2000);
        logp.SignIn.click();                       // Sign in 
	}	
} 