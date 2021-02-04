package pomCRM.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Listerners.WebEventListener;
import pomCRM.Util.TestUtil;

public class BaseMethodClass {


	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;


	public BaseMethodClass() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("/Users/vikashkashyap/Desktop/TestLeaf/pomCRM/src/main/java/pomCRM/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String BrowserName= prop.getProperty("browser");

		if(BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver" , "./driver/chromedriver");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "./driver/iedriver");
			driver=new InternetExplorerDriver();


		}

		else if(BrowserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver" , "./driver/chromedriver");
			driver=new FirefoxDriver();


		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("URL"));
	}

}

