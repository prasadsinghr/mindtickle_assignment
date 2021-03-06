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
import mt.qa.pages.LoginPage;
import mt.qa.util.CustomeListeners;
import mt.qa.util.TestUtil;

@Listeners(CustomeListeners.class)
public class AddLearningContentPageTest extends TestBase
{
	LoginPage loginpage;
	ContentHomePage homepage;
	CreateNewCoursePage createpage;
	CreateTopicAndPublishPage createtopicpublish	;
	EditCourseTopicPage editcourse;
	AddLearningContentPage addcontent;
	
	@BeforeSuite()
	public void setUp()
	{
		launchBrowser();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		createpage =homepage.createCourse();
		createtopicpublish	=new CreateTopicAndPublishPage();
		editcourse = new EditCourseTopicPage();
		addcontent= new AddLearningContentPage();
	}

	@Test(priority=1)
	public void validateHeader()
	{
		String header=	addcontent.validateheader();
		Assert.assertEquals(header,"Add Content, Questions and Polls","invalid header");
	}
	
	@Test(priority=2,dataProvider="addLearningDataProviderMethod")
	public void addLearningContent(String Header,String descriptions,String Series, String Topic_name,String filepath) throws InterruptedException, IOException
	{
		createtopicpublish=createpage.createCourse(Header,descriptions,Series);
		createtopicpublish.addCourse(Topic_name);
		editcourse.contentClick();
		Assert.assertTrue(addcontent.validateEle(), "invalid page");
		addcontent.addLearingContent(filepath);
	}
	@DataProvider
	public Object[][] addLearningDataProviderMethod()
	{
		Object[][] data = TestUtil.getTestData("Add_LearingContent");
		return data;
	}
	@AfterSuite
	public void closure()
	{
		driver.quit();
	}
	
	
}
