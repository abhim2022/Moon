package planet.moon.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import planet.moon.base.Base;
import planet.moon.pages.HmPage;
import planet.moon.pages.LgnPage;

public class LgnTest extends Base{

	LgnPage loginPage;
	HmPage homePage;

	@BeforeMethod
	public void setup(){
		initializePropertyfile();
		initializeBrowser();
		System.out.println("logintest pagefactory");
		loginPage = new LgnPage();
		homePage = new HmPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateTitleOfLoginPage();
		System.out.println("Login Page title = "+title);
		Assert.assertEquals(title.trim(), "Cogmento CRM","Login Page title not matched!");
	}
	
	@Test(priority=2)
	public void loginTest(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String name = homePage.verifyLoggedInUserName();
		System.out.println("name="+name);
		Assert.assertEquals(name,"Abhineet Mishra");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	

}