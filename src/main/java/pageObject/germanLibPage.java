package pageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;


public class germanLibPage {
	public germanLibPage(AppiumDriver<?> driver) {
	
	       PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//XCUIElementTypeButton[@name='Weiter']")
	public WebElement login;
	
	@FindBy(id="Fertig")
	public WebElement Done;
	
	@FindBy(id="Siehe Maschine Zur Miete verfügbar")
	public WebElement textToCompare;
	
	@FindBy(xpath="//XCUIElementTypeButton[@name='Konto\nTab 5 von 5']")
	public WebElement account;
	
	@FindBy(id="Ausloggen")
	public WebElement logOut;
	
	@FindBy(id="OK")
	public WebElement OK;
}
