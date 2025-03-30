package pageObject;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;


public class norweigenLibPage {
	public norweigenLibPage(AppiumDriver<?> driver) {
	
	       PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="Utstyr\nFane 2 av 5")
	public WebElement equipmentIcon;
	
	@FindBy(id="Konto\nFane 5 av 5")
	public WebElement accountIcon;
	
	@FindBy(id="English\n(Phone's Language)")
	public WebElement englishLanguage;
	
	@FindBy(id="Norsk")
	public WebElement norsk;
	
	@FindBy(id="Leid utstyr")
	public WebElement rentedEquipmentTab;
	
	@FindBy(id="Bruk utstyret")
	public WebElement useEquipment;
	
	@FindBy(xpath="//XCUIElementTypeButton")
    public WebElement closePage;
	
	@FindBy(id="AVBRYT")
	public WebElement abandonDialog;
	
	@FindBy(id="Tilbake")
	public WebElement backArrow;
	
	@FindBy(id="English\\n(Telefonens språk)")
	public WebElement switchToEnglish;
	
	@FindBy(xpath="//XCUIElementTypeButton")
	public List<WebElement> list;
	
	List<WebElement> List()
	{
		return list;
	}	
	
		
}   
