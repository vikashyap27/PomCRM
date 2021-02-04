package pomCRM.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomCRM.base.BaseMethodClass;
import pomCRM.pages.HomePage;
import pomCRM.pages.LoginPage;

public class LoginTestPage extends BaseMethodClass {
	LoginPage LP;
	HomePage  HP;
	public LoginTestPage(){
	super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		 LP = new LoginPage();
	}
	
	@Test(priority =2)
	public void LoginPageTitleTest() {
		String Title = LP.validateLoginPage();
		AssertJUnit.assertEquals(Title, "Cogmento CRM");
	}
	
	@Test(priority =1)
	public  void LoginTest() {
		HP = LP.login(prop.getProperty("username"), prop.getProperty("password"));
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
