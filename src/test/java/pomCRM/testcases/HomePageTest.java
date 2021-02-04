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
import pomCRM.pages.CreateContactsPage;
import pomCRM.pages.HomePage;
import pomCRM.pages.LoginPage;

public class HomePageTest extends BaseMethodClass {

	LoginPage LP;
	HomePage  HP;
	CreateContactsPage CP;
	public HomePageTest(){
	super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		 LP = new LoginPage();
		 HP = new HomePage();
	}
	
	@Test(priority =2)
	public void HomePageTitleTest() {
		HP = LP.login(prop.getProperty("username"), prop.getProperty("password"));
		String Title = HP.ValidateHomePage();
		AssertJUnit.assertEquals(Title, "Cogmento CRM");
	}
	
	@Test(priority =1)
	public  void ClickContacts() throws InterruptedException {
	HP = LP.login(prop.getProperty("username"), prop.getProperty("password"));
	CP=	HP.clickNewContactlink();
		
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
