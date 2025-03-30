package utility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import pageObject.commentPage;
import pageObject.equipmentDetailsPage;
import pageObject.equipmentPage;
import resources.BaseIOSTest;


public class Comment extends BaseIOSTest {
	private static IOSDriver<WebElement> driver;   // declare local driver
	public Comment(IOSDriver<WebElement> driver)
	{
		Comment.driver=driver;   // assigned the driver to local driver
	}
	

	public static void insert(String sentence) throws InterruptedException
	{
		 
		commentPage field=new commentPage(driver);
		field.Comment().sendKeys(sentence);
		field.Done();
	}	
}