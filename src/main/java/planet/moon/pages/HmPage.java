package planet.moon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import planet.moon.base.Base;
import planet.moon.utiliti.UtilitiClass;

public class HmPage extends Base{

	
	public HmPage(){
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="//*[@id='top-header-menu']/div[2]/span[1]")
	public WebElement loggedInUserName;

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String verifyLoggedInUserName(){
		String name  = getLoggedInUserName().getText();
		System.out.println("name="+name);
		return name;
		
	}

	public WebElement getLoggedInUserName() {
		UtilitiClass.waitForElementPresent(driver, loggedInUserName);
		return loggedInUserName;
	}
	
	
	
	
	
	
	


}
