package mt.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import mt.qa.base.TestBase;
import mt.qa.util.TestUtil;

public class InviteLearersPage extends TestBase
{
	
	@FindBy(xpath="//div[@class='inviteText'][text()='Invite Learners']")
	private	WebElement invitebutton;
	
	@FindBy(xpath="//div[text()='To Course Only']")
	private	WebElement tocouseronly;
	
	@FindBy(xpath="//li[@class='invite_to_series_course_subdd bg_f7 display_N']")
	private	List<WebElement> listofcourseonly;
	
	@FindBy(xpath="//input[@id='newEmailField']")
	private	WebElement emailid;
	
	@FindBy(xpath="//input[@id='newNameField']")
	private	WebElement name;
	
	@FindBy(xpath="//div[text()='Add to List']")
	private	WebElement addtolistbtn;
	
	@FindBy(xpath="//div[@class='floatL btn_0072bc F13 lineHeight30 borderR15 paddingL25 paddingR25 addAndInviteAll'][text()='Add & Invite All']")
	private	WebElement addinviteallbtn;
	
	public boolean validateEle()
	{
		return TestUtil.validateElements(invitebutton);
	}
	
	public String inviteleaners(String whome,String email,String namef)
	{
		invitebutton.click();
		tocouseronly.click();
		for(int i=0;i<listofcourseonly.size();i++)
		{
			System.out.println(listofcourseonly.size());
			if(listofcourseonly.get(i).getText().contains(whome))
			{
				listofcourseonly.get(i).click();
			}
		}
		emailid.sendKeys(email);
		name.sendKeys(namef);
		addtolistbtn.click();
		addinviteallbtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		WebElement abc = driver.findElement(By.xpath("//span[text()='"+namef+"']"));
		String validatedname=abc.getText().toString();
		System.out.println("verify ele "+validatedname);

		return validatedname;
	}

}
