package pomCRM.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomCRM.base.BaseMethodClass;

public class HomePage extends BaseMethodClass {

	
	@FindBy(xpath ="(//div[@class='menu-item-wrapper']//a)[3]")
	WebElement Contacts;
	
	@FindBy(xpath ="(//button[@class='ui mini basic icon button'])[2]")
	WebElement NewContacts;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateHomePage()
	{
		return driver.getTitle();
		
	}
	public CreateContactsPage clickNewContactlink() throws InterruptedException {
		
		Actions action = new Actions(driver);
			
		action.moveToElement(Contacts).build().perform();
		
		Contacts.click();
		
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", NewContacts);
		//NewContacts.click();
		
		Thread.sleep(4000);
		return new CreateContactsPage();
		
		
	}
	
	public ContactsPage ClickContacts() throws InterruptedException {
		
		Actions action = new Actions(driver);
			
		action.moveToElement(Contacts).build().perform();
		
		Contacts.click();
		
		Thread.sleep(4000);

		return new ContactsPage();
		
		
	}
}


