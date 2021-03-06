package mt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import mt.qa.base.TestBase;
import mt.qa.util.TestUtil;

public class CreateTopicAndPublishPage extends TestBase
{

	@FindBy(xpath="//div[@class='topicDiv add addModular pos_abs']")
	private WebElement clicktoaddtopic;

	@FindBy(xpath="//textarea[@class='display_N marginL6 editArea']")
	private WebElement textareatoaddtopic;

	@FindBy(xpath="//span[text()='Publish']")
	private	WebElement publish;
	
	@FindBy(xpath="//div[@class='btn_0072bc_30 F13 yesBtnTxt floatL paddingL30 paddingR30'][text()='Confirm Publish']")
	private	WebElement confirmToPublish;
	
	@FindBy(xpath="//div[@class='btn_0072bc_30 F13 paddingL30 paddingR30 okbtn']")
	private	WebElement oktn;
	
	public String validateTitle()
	{
		String topictitle=driver.getTitle();
		return topictitle;
	}
	
	public boolean validateEle()
	{
		return TestUtil.validateElements(clicktoaddtopic);
	}
	
	public boolean validateEle2()
	{
		return TestUtil.validateElements(publish);
	}
	
	public void addCourse(String Topicname) throws InterruptedException
	{
		clicktoaddtopic.click();
		Thread.sleep(1000);
		textareatoaddtopic.sendKeys(Topicname);
	}
	
	public void publishcourse()
	{
		publish.click();
	}
	
	public void confirmToPublish()
	{
		confirmToPublish.click();
	}
	
	public void clickOnOk()
	{
		oktn.click();	
	}
	
}
