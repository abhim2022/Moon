package planet.moon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import planet.moon.utiliti.MyTestListener;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_firer;
	public static MyTestListener myListener;
	
	public static void initializePropertyfile(){
		prop = new Properties();
		
			FileInputStream fis;
			try {
				//String propFilePath = System.getProperty("user.dir")+"/FreeCRM/src/main/java/com/crm/config/configuration.properties";
				//System.out.println("propFilePath="+propFilePath);
				fis = new FileInputStream("F:\\Auto\\workspace\\Moon\\src\\main\\java\\planet\\moon\\config\\confi.properties");
				prop.load(fis);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}	
				
	}

	
	public void initializeBrowser(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhineet Mishra\\Documents\\FrontLine\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	
	e_firer = new EventFiringWebDriver(driver);
	myListener = new MyTestListener();
	e_firer.register(myListener);
	driver = e_firer;
	//driver = decorator;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}



}
