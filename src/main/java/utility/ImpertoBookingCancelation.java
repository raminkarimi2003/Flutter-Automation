package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import pageObject.bluetoothPage;
import pageObject.impertoBookingPage;
import pageObject.impertoLoginPage;

public class ImpertoBookingCancelation  {
		
	
		
	public static void signIn(WebDriver seleniumdriver, String customer) throws InterruptedException
	{
		
		impertoBookingPage bk=new impertoBookingPage(seleniumdriver);
       // bk.impertoBookingButton.click();  // click booking button
       // Thread.sleep(2000);
        bk.impertoCustomerSearch.sendKeys(customer);  // search for specific customer
		Thread.sleep(2000);
        seleniumdriver.findElement(By.xpath("//td[contains(text(),'"+customer+"')]")).click(); // select and click on the customer
		Thread.sleep(2000);
        bk.impertoBookingDelete.click(); // click on delete button
//        Thread.sleep(1000);
//		String tag=bk.impertoDeleteConfirmationID.getText(); // extract the text from real time confirmation ID
//		System.out.println("The confirmation number is "+tag);
//		bk.impertoConfirmation.sendKeys(tag); // print the confirmation ID in the confirmation field
		//bk.impertoConfirmationButton.click(); //click on the confirmation button
	} 
	
	
	
}