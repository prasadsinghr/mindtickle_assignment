package assignment.mindtickle;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import mt.qa.base.TestBase;
import mt.qa.pages.AddLearningContentPage;
import mt.qa.pages.ContentHomePage;
import mt.qa.pages.CreateNewCoursePage;
import mt.qa.pages.CreateTopicAndPublishPage;
import mt.qa.pages.EditCourseTopicPage;
import mt.qa.pages.InviteLearersPage;
import mt.qa.pages.LoginPage;
import mt.qa.util.CustomeListeners;
import mt.qa.util.TestUtil;

@Listeners(CustomeListeners.class)
public class InviteLearersPageTest extends TestBase
{
	LoginPage loginpage;
	ContentHomePage homepage;
	CreateNewCoursePage createcourse;
	CreateTopicAndPublishPage createtopicpublish;
	EditCourseTopicPage editcourse;
	AddLearningContentPage addcontent;
	InviteLearersPage invite;	
	
	@BeforeSuite()
	public void setUp()
	{
		launchBrowser();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		createcourse =homepage.createCourse();
		createtopicpublish=new CreateTopicAndPublishPage();
		editcourse = new EditCourseTopicPage();
		addcontent= new AddLearningContentPage();
		invite= new InviteLearersPage();
	}

	

	@Test(priority=1,dataProvider="publishCourseDataProviderMethod")
	public void inviteLearner(String Header,String descriptions,String Series, String Topic_name,String filepath,String towhome,String email,String name) throws InterruptedException, IOException
	{
		createtopicpublish=createcourse.createCourse(Header,descriptions,Series);
		createtopicpublish.addCourse(Topic_name);
		editcourse.contentClick();
		addcontent.addLearingContent(filepath);
		addcontent.back();
		createtopicpublish.publishcourse();
		createtopicpublish.confirmToPublish();
		createtopicpublish.clickOnOk();
		String nameOnscreen=invite.inviteleaners(towhome, email, name);
		Assert.assertEquals(nameOnscreen, name,"invalid learner invited");
	}
	
	@DataProvider
	public Object[][] publishCourseDataProviderMethod()
	{
		Object[][] data = TestUtil.getTestData("InviteLearniner");
		return data;
	}

	@AfterSuite
	public void closure()
	{
		driver.quit();
	}
	
	
}
