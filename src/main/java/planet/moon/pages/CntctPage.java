package planet.moon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import planet.moon.base.Base;
import planet.moon.utiliti.UtilitiClass;

public class CntctPage extends Base {

	
	public CntctPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	@CacheLookup
	WebElement btnCreate;
	
	@FindBy(name="first_name")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(name="last_name")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(xpath="//*/input[@placeholder='Email address']")
	@CacheLookup
	WebElement txtEmailAddress;
	
	@FindBy(xpath="*//div[@name='company']/input")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	@CacheLookup
	WebElement btnSave;
	
	@FindBy(xpath="//*[@id='main-nav']/div[3]/a")
	WebElement menuContact;
	
	public WebElement getTxtCompany() {
		UtilitiClass.waitForElementPresent(driver, txtCompany);
		return txtCompany;
	}
	
	public WebElement getTxtEmailAddress() {
		UtilitiClass.waitForElementPresent(driver, txtEmailAddress);
		return txtEmailAddress;
	}
	public WebElement getBtnCreate() {
		UtilitiClass.waitForElementPresent(driver, btnCreate);
		return btnCreate;
	}
	public WebElement getTxtFirstName() {
		UtilitiClass.waitForElementPresent(driver, txtFirstName);
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		UtilitiClass.waitForElementPresent(driver, txtLastName);
		return txtLastName;
	}

	public WebElement getBtnSave() {
		UtilitiClass.waitForElementPresent(driver, btnSave);
		return btnSave;
	}
	
	public WebElement getMenuContact() {
		UtilitiClass.waitForElementPresent(driver, menuContact);
		return menuContact;
	}
	
	public void createContact(String fName,String lName,String email){
		getMenuContact().click();
		getBtnCreate().click();
		getTxtFirstName().sendKeys(fName);
		getTxtLastName().sendKeys(lName);
		getTxtEmailAddress().sendKeys(email);
		getBtnSave().click();
		
	}

	
	

}
