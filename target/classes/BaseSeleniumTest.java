package resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


// System.getProperty("user.dir") get the working directory where program was launched from
// System.gertProperty(" ") this method get the system property indicated by specific key
public class BaseSeleniumTest {
	
    public static WebDriver Seleniumdriver;
    public static Properties prop;
    public static  String url;
	
	public static void InitializeSeleniumDriver() throws IOException, InterruptedException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/global.properties");
		prop.load(fis);
		url=prop.getProperty("url");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/driverResources/chromedriver");
		Seleniumdriver=new ChromeDriver();	
		
 }	
	
	public static void tap(String elementName,WebDriver driver) throws InterruptedException
    {
        WebElement element=driver.findElement(By.cssSelector(elementName));
		String title=element.getText();
		System.out.println("Title is "+title);
		Actions action= new Actions(driver);
		action.doubleClick(element);
    }

}