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
import pomCRM.pages.ContactsPage;
import pomCRM.pages.CreateContactsPage;
import pomCRM.pages.HomePage;
import pomCRM.pages.LoginPage;

public class ContactsPageTest  extends BaseMethodClass{

	
	LoginPage LP;
	HomePage  HP;
	ContactsPage CP;

	public ContactsPageTest(){
	super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		 LP = new LoginPage();
		 HP = new HomePage();
		 CP = new ContactsPage();
	}
	
	@Test(priority =1)
	public void ConatctsPageTitleTest() throws InterruptedException {
		
		LP.login(prop.getProperty("username"), prop.getProperty("password")).ClickContacts();
		String Title = CP.ValidateContactsPage();
		AssertJUnit.assertEquals(Title, "Cogmento CRM");
	}
	
	@Test(priority =2)
	public void deleteContacts() throws InterruptedException {
		LP
		.login(prop.getProperty("username"), prop.getProperty("password"))
		.ClickContacts()
		.deleteContactsTest();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
