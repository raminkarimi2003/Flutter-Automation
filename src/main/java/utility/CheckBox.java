package utility;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.appium.java_client.ios.IOSDriver;
import pageObject.checkEquipmentPage;
import resources.BaseIOSTest;

public class CheckBox{

	private static boolean logInfo;
	private static IOSDriver<?> driver;   // declare local driver
	private static Logger log=LogManager.getLogger(CheckBox.class.getName()); // defining log4j manager for this class 
	public CheckBox(IOSDriver<?> driver)
	{
		CheckBox.driver=driver;   // assigned the driver to local driver(instance of the class)
	}
	
	public CheckBox(IOSDriver<?> driver, boolean logInfo)   // overloading constructor for logging purposes
	{
		CheckBox.driver=driver;   // assigned the driver to local driver of the class
		CheckBox.logInfo=logInfo;
	}
	
    public static void check() throws InterruptedException 
    {
    	 checkEquipmentPage ce=new checkEquipmentPage(driver);      // Create object for 'checkEquipmentPage'
    	 
    	 List<String[]> listofArray=new ArrayList<>();
    	 String[] arrayOfStrings1= {"Sheet metal*","Tire track*"};  // initialize array of strings 
         String[] arrayOfStrings2={"Cab*","Operator manual*","Fire extinguisher*","Control panel*","Reversing alarm*","Motion alarm*","Decals and labels legible*"}; // initialize array of strings 2
         
         listofArray.add(arrayOfStrings1); // add the array to the list
         listofArray.add(arrayOfStrings2);
            
        int page=0;
      
        for(String[] Array:listofArray)
        {
         	page++;
         
        	for(String element:Array)
         	{
         		    System.out.println("page is "+page);
         			driver.findElementByAccessibilityId(element).click();
        			
         	}
         		
        	if(page==1)
     		    ce.Continue.click(); // Go to the next page for the checklist
     		else 
     		{
     			Thread.sleep(1000);
     			if(logInfo)
     			{
     			 long startTime = System.nanoTime();
     			 ce.Submit.click();
     			 driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
     			 long endTime = System.nanoTime();
     	         log.info("The Disconnection time for the asset is "+ (endTime - startTime) / 1_000_000_000.0 +" seconds"); // get the time elapsed in seconds and log it

     			 System.out.println("Disconnection time: " + (endTime - startTime) / 1_000_000 + " ms");
     			}
     			else
     			{
     			 ce.Submit.click();
         		 driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);	
     			}
     		}
         }

        	
    }
    	
}