package utility;

import java.util.List;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.MobileBy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.google.common.collect.ImmutableMap;



public class NonStaticDropDown  {
		
	
	public static void selectItemFromDropdownList(List<WebElement> list, String org, IOSDriver<WebElement> driver,String dir) {
	    boolean itemFound = false;
	    
	    while (!itemFound) {
	        for (WebElement itemList : list) {
	            String item = itemList.getAttribute("name");
	            System.out.println("Item in the list: " + item);

	            if (item.equalsIgnoreCase(org)) { // If the desired item is found
	                itemList.click();
	                itemFound = true;
	                break;
	            }
	        }

	        if (!itemFound) {
	            // Scroll up or down dynamically until item is found
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("mobile: scroll", ImmutableMap.of("direction", dir));
	            // Important: You should re-fetch the list after scrolling, as the DOM might have changed.
	            
	        }
	    } // end of while loop
	    
	}   
	    
	    public static void item(List<WebElement>list, String org) throws InterruptedException
		{
			 for(WebElement itemList: list)
		        {
		        	String item=itemList.getText();
		        	System.out.println("item in the list is "+item);
		        	if(item.equalsIgnoreCase(org)) // org drop down for IMP
		        	{
		        		
		        		itemList.click();
		        	    break;
		        	}    
		        }
	   }
     
	
	    public static void selectItemFromDropdown(List<WebElement> list, String org, IOSDriver<WebElement> driver) {
	        boolean itemFound = false;
	        String dir="down";

	        for (WebElement itemList : list) {
	            String item = itemList.getAttribute("name");
	            System.out.println("Item in the list: " + item);

	            if (item != null && item.equalsIgnoreCase(org)) {
	                itemList.click();
	                itemFound = true;
	                break;
	            }
	        }

	        while (!itemFound) { // Keep the while loop for scrolling
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("mobile: scroll", ImmutableMap.of("direction", dir)); // Use 'dir' directly
	            
	            // Important: You should re-fetch the list after scrolling, as the DOM might have changed.
	           // list = driver.findElements(By.xpath("//XCUIElementTypeOther[@name='Forgrunnsmeny']//XCUIElementTypeButton"));

	            // Check the list again to see if the element is now available
	            for (WebElement itemList : list) {
	                String item = itemList.getAttribute("name");
	                System.out.println("Item in the list: " + item);

	                if (item != null && item.equalsIgnoreCase(org)) { // If the desired item is found
	                    itemList.click();
	                    itemFound = true;
	                    break;
	                }
	            }

	            if (!itemFound && dir.equals("down")){
	                dir = "up";
	            } else if (!itemFound && dir.equals("up")){
	                throw new RuntimeException("Element not found in the list.");
	            }
	        }
	    }
//  for(int i=0;i<siteSelect.size();i++)
//  {
//  	if(siteSelect.get(i).getText().equalsIgnoreCase("siteshare-dev"))
//  	{
//  	
//  		siteSelect.get(i).click();
//  		break;
//  	}
//  }

}	