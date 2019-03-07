package mt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import mt.qa.base.TestBase;
import mt.qa.util.TestUtil;

public class ContentHomePage extends TestBase
{

	@FindBy(xpath="//div[text()='Create']")
	private WebElement createbutton;
	
	@FindBy(xpath="//div[text()='Course']")
	private WebElement courselink;
	
	public String homePageTitle()
	{
	String Htitle=driver.getTitle();
	return Htitle;
	}
	public boolean validateEle()
	{
		return TestUtil.validateElements(createbutton);
	}
	public CreateNewCoursePage createCourse()
	{
		createbutton.click();	
		courselink.click();
		return new CreateNewCoursePage();
	}

}
