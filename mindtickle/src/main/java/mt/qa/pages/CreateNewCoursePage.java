package mt.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import mt.qa.base.TestBase;
import mt.qa.util.TestUtil;

public class CreateNewCoursePage extends TestBase
{

	@FindBy(xpath="//div[text()='Create New Course']")
	private WebElement createcoursepageheader;

	@FindBy(xpath="//input[@id='trngName']")
	private WebElement trainingname;

	@FindBy(xpath="//body[@id='tinymce']")
	private WebElement trainingdesc;

	@FindBy(xpath="//a[@class='boxSizing_cb']")
	private WebElement selectseries;

	@FindBy(xpath="//div[2][text()='Create']")
	private WebElement createbutton;

	@FindBy(xpath="//dl[@class='sortDD pos_rel floatL seriesDD']/dd/ul")
	private List<WebElement> options;


	public String createCoursePageheader()
	{
		String ctitle= createcoursepageheader.getText();
		return ctitle;
	}

	public boolean validateEle()
	{
		return TestUtil.validateElements(createcoursepageheader);
	}
	public CreateTopicAndPublishPage createCourse(String header,String desc,String select) throws InterruptedException
	{
		trainingname.sendKeys(header);
		TestUtil.switchToFrame();
		//Thread.sleep(10);
		trainingdesc.sendKeys(desc);
		TestUtil.switchToDefaultFrame();
		selectseries.click();
		for(int i=0;i<options.size();i++)
		{
			if(options.get(i).getText().contains(select))
			{
				options.get(i).click();
			}
		}
		createbutton.click();
		return new CreateTopicAndPublishPage();
}




}
