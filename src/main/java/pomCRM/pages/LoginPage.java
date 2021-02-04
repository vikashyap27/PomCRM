package pomCRM.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pomCRM.base.BaseMethodClass;

public class LoginPage extends BaseMethodClass{

	@FindBy(name ="email")
	WebElement Username;

	@FindBy(name ="password")
	WebElement password;


	@FindBy(xpath ="//div[text()='Login']")
	WebElement LoginBtn;

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPage() {

		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {
		Username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();

		return new HomePage();
	}
}
