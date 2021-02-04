package pomCRM.pages;

import org.apache.commons.math3.ode.events.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomCRM.Util.TestUtil;
import pomCRM.base.BaseMethodClass;

public class CreateContactsPage extends BaseMethodClass {

	
	@FindBy(name ="first_name")
	WebElement firstName;
	
	@FindBy(name ="last_name")
	WebElement LastName;
	
	@FindBy(name ="category")
	WebElement Category;
	
	@FindBy(name ="description")
	WebElement Description;

	@FindBy(name ="position")
	WebElement Position;
	
	@FindBy(name ="identifier")
	WebElement Identifier;
	
	
	@FindBy(xpath ="(//div[@name='category'])[2]")
	WebElement SelectCategory;
	
//	/Users/vikashkashyap/Desktop/TestLeaf/pomCRM/TestData/Conatcts.xlsx

	
	@FindBy(xpath ="//button[text()='Save']")
	WebElement SaveBtn;
	
	public CreateContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateCreateContactsPage() {
		
		return driver.getTitle();
		
	}
	
	public ContactsPage entercontactsDetails(String fName, String LName , String Cat, String Des, String Pos, String Iden) throws InterruptedException {
		
//		Actions builder = new Actions(driver);
//        builder.moveToElement(firstName).build().perform();
//		TestUtil.EnterData(firstName, fName);
//		TestUtil.EnterData(LastName, LName);
//		TestUtil.EnterData(Category, Cat);
//		TestUtil.EnterData(Description, Des);
//		TestUtil.EnterData(Position, Pos);
//		TestUtil.EnterData(Identifier, Iden);
		firstName.sendKeys(fName);
		Thread.sleep(3000);
	
		LastName.sendKeys(LName);
		Thread.sleep(3000);
		Category.sendKeys(Cat);
		Thread.sleep(3000);
		Description.sendKeys(Des);
		Thread.sleep(3000);
		Position.sendKeys(Pos);
		Thread.sleep(3000);
		Identifier.sendKeys(Iden);
		
		
		Thread.sleep(3000);
		
//		Category.click();
//		
//		SelectCategory.click();
		
		SaveBtn.click();
		
		Thread.sleep(3000);
		
		return new ContactsPage();
		
	}
}
