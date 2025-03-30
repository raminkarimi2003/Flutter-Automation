package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import pageObject.bluetoothPage;
import pageObject.impertoLoginPage;
import org.openqa.selenium.interactions.Actions;
public class ImpertoLogin  {
		
	
		
	public static void signIn(WebDriver seleniumdriver) throws InterruptedException
	{
		
		impertoLoginPage lg = new impertoLoginPage(seleniumdriver);
		WebDriverWait wait = new WebDriverWait(seleniumdriver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(lg.impertoRegister)).click();
        Thread.sleep(3000);
        lg.impertoEmail.sendKeys("ramin.karimi@irdeto.com");
        lg.impertoPasswd.sendKeys("Shabooly12!");
        lg.impertoSubmit.click();
        Thread.sleep(3000);
	} 	
}