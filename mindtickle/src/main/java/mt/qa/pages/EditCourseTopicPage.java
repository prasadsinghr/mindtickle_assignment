package mt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import mt.qa.base.TestBase;
import mt.qa.util.TestUtil;

public class EditCourseTopicPage extends TestBase
{

	@FindBy(xpath="//div[@class='floatL color99 F13'][contains(text(),'Content')] ")
	private WebElement editmenu;
	
	public void contentClick()
	{
		editmenu.click();
		editmenu.click();
	}	
	public boolean validateEle()
	{
		return TestUtil.validateElements(editmenu);
	}

}
