package mt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import mt.qa.base.TestBase;

public class LoginPage extends TestBase
{
		
	@FindBy(id="loginEmail")
	private WebElement username;

	@FindBy(xpath="//input[@name='password']")
	private WebElement password;

	@FindBy(xpath="//button[@value='Sign In']")
	private WebElement signin;

	
	public String loginPageTitle()
	{
		String ltitle= driver.getTitle();
		return ltitle;
	}
	
	public ContentHomePage login(String uname,String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		signin.click();
		return new ContentHomePage();
		
	}
	
	
}
