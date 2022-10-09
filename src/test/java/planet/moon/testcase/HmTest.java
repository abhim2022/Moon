package planet.moon.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import planet.moon.base.Base;
import planet.moon.pages.HmPage;
import planet.moon.pages.LgnPage;

public class HmTest extends Base {

	
	HmPage homePage;
	LgnPage loginPage;
	
	
	@BeforeMethod
	public void preTest(){
		initializePropertyfile();
		initializeBrowser();
		loginPage = new LgnPage();
		homePage = new HmPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=3)
	public void validateHomePageTitleTest(){
		String title = homePage.verifyHomePageTitle();
		System.out.println("HomePageTitle = "+title.trim());
		Assert.assertEquals(title.trim(), "Cogmento CRM","Home Page title not matched!");
		
	}
	
	@Test(priority=4)
	public void validateLoggedInUserNameTest(){
		String name = homePage.verifyLoggedInUserName();
		Assert.assertEquals(name, "Abhineet Mishra");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	


}
