package pomCRM.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomCRM.base.BaseMethodClass;

public class ContactsPage extends BaseMethodClass {

	@FindBy(name ="id")
	WebElement ID;

	@FindBy(xpath ="//i[@class='trash alternate outline icon']")
	WebElement delete;



	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}

	public String ValidateContactsPage() {

		return driver.getTitle();

	}

	public void deleteContactsTest() throws InterruptedException {
		//	ID.click();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ID);

		Thread.sleep(3000);
		delete.click();
		Thread.sleep(3000);

	}
}
