package mt.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import mt.qa.util.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	public TestBase() 
	{
		try
		{
			prop=new Properties();
			FileInputStream file =  new FileInputStream("D:\\mindtickle_assignment\\mindtickle\\src\\main\\java\\mt\\qa\\config\\config.properties");
			prop.load(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	
	}
	
	public static void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\mindtickle_assignment\\mindtickle\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
/*
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
	*/
	}
	
	
	
}
