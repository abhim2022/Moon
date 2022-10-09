package planet.moon.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import planet.moon.base.Base;
import planet.moon.pages.CntctPage;
import planet.moon.pages.LgnPage;
import planet.moon.utiliti.UtilitiClass;

public class CntctTest extends Base {

	
	CntctPage contactPage;
	LgnPage loginPage;
	String sheetName = "contacts";
	
	 
	@BeforeMethod
	public void setup(){
		initializePropertyfile();
		initializeBrowser();
		contactPage = new CntctPage();
		loginPage= new LgnPage();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = UtilitiClass.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=5,dataProvider="getCRMTestData")
	public void createContact(String firstname, String lastname, String email){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage.createContact(firstname, lastname, email);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	
	


}
