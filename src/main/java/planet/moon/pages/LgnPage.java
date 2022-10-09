package planet.moon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import planet.moon.base.Base;
import planet.moon.utiliti.UtilitiClass;

public class LgnPage extends Base {

	
	public LgnPage(){
		PageFactory.initElements(driver, this);
	}
	
	// Object repositories or xpaths or webelements 
		
	@FindBy(name="email")
	WebElement usernameTxt;

	@FindBy(name="password")
	WebElement passwordTxt;
	
	@FindBy(xpath="//input[@name='password']/following::div[1]")
	WebElement loginBtn;
	
	public WebElement getUsernameTxt() {
		System.out.println("before fluent wait started !");
		UtilitiClass.waitForElementPresent(driver, usernameTxt);
		System.out.println(" after fluent wait ended!");
		return usernameTxt;
	}

	public WebElement getPasswordTxt() {
		UtilitiClass.waitForElementPresent(driver, passwordTxt);
		return passwordTxt;
	}

	public WebElement getLoginBtn() {
		UtilitiClass.waitForElementPresent(driver, loginBtn);
		return loginBtn;
	}
	//actions
	public String validateTitleOfLoginPage(){
		return driver.getTitle();
	}
	
	public HmPage login(String un,String pwd){
		getUsernameTxt().sendKeys(un);
		getPasswordTxt().sendKeys(pwd);
		getLoginBtn().click();
		return new HmPage();
		
	}
	


}
