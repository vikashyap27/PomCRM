package pomCRM.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pomCRM.Util.TestUtil;
import pomCRM.base.BaseMethodClass;
import pomCRM.pages.CreateContactsPage;
import pomCRM.pages.HomePage;
import pomCRM.pages.LoginPage;

public class CreateContactsPageTest extends BaseMethodClass {

	LoginPage LP;
	HomePage  HP;
	CreateContactsPage CCP;
	String sheetName = "Contacts";
	public CreateContactsPageTest(){
	super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		 LP = new LoginPage();
		 HP = new HomePage();
		 CCP = new CreateContactsPage();
	}
	
	@Test(priority =2)
	public void ConatctsPageTitleTest() throws InterruptedException {
		
		LP.login(prop.getProperty("username"), prop.getProperty("password")).clickNewContactlink();
		String Title = CCP.ValidateCreateContactsPage();
		AssertJUnit.assertEquals(Title, "Cogmento CRM");
	}
	
	@Test(priority =1)
	public  void CreateNewContactsTest() throws InterruptedException {
		
		LP.login(prop.getProperty("username"), prop.getProperty("password")).clickNewContactlink();
	}
	
	@DataProvider
	public Object[][] getCRMcelldata() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider = "getCRMcelldata")
	public void ValidateCreateNewContacts(String firstName, String LastName , String Category, String Description, String Position, String Identifier) throws InterruptedException {
		LP
		.login(prop.getProperty("username"), prop.getProperty("password"))
		.clickNewContactlink()
		.entercontactsDetails(firstName, LastName, Category, Description, Position, Identifier);
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
