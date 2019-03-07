package mt.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import mt.qa.base.TestBase;
import mt.qa.util.TestUtil;

public class AddLearningContentPage extends TestBase
{
	@FindBy(xpath="//div[@class='textalign_C color36 F18 lineHeight28 borderB35_transparent'][text()='Add Content, Questions and Polls']")
	private WebElement header;
		
	@FindBy(xpath="//div[@class='floatL colorcc F13 marginL7 addText'][text()='Add Content, Questions and Polls']")
	private WebElement addcontent_que_polls;

	@FindBy(xpath="//div[@class='F18 marginB5'][text()='Upload Content']")
	private WebElement uploadcontent;

	@FindBy(xpath="//div[@class='learningContentTypeDummy margin0_auto']")
	private WebElement dropfiles;
	
	@FindBy(xpath="//div[@class='upload_label'][text()='Upload from Computer']")
	private WebElement uploadfrompc;

	@FindBy(xpath="//div[@class='floatL colorff_F14 lineHeight48 marginL5 marginT16 display_N headerContentEditBackBtn doneBtn backArrow_10_16_fff cursor tooltip_bottom_left']")
	private	WebElement backbutton;

	public String validateheader()
	{
		String hdr=	header.getText();
		return hdr;
	}

	public boolean validateEle()
	{
		return TestUtil.validateElements(addcontent_que_polls);
	}

	public void addLearingContent(String filepath) throws IOException, InterruptedException
	{
		addcontent_que_polls.click();
		uploadcontent.click();
		dropfiles.click();
		uploadfrompc.click();
		Runtime.getRuntime().exec(filepath);
		Thread.sleep(9000);
	}

	public void back()
	{
		backbutton.click();
	}
}