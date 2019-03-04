package assignment.mindtickle;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import mt.qa.base.TestBase;
import mt.qa.pages.ContentHomePage;
import mt.qa.pages.CreateNewCoursePage;
import mt.qa.pages.CreateTopicAndPublishPage;
import mt.qa.pages.LoginPage;
import mt.qa.util.CustomeListeners;
import mt.qa.util.TestUtil;

@Listeners(CustomeListeners.class)
public class CreateTopicPageTest extends TestBase
{
	LoginPage loginpage;
	ContentHomePage homepage;
	CreateNewCoursePage createcourse;
	CreateTopicAndPublishPage createtopicpublish;
	
	@BeforeSuite()
	public void setUp()
	{
		launchBrowser();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		createcourse =homepage.createCourse();
		createtopicpublish=new CreateTopicAndPublishPage();
	}

	@Test
	public void validatePageTitle()
	{
		String title=createtopicpublish.validateTitle();
		Assert.assertEquals(title, "Content Home","Invalid title for create topic page");
	}
	
@Test(priority=1,dataProvider="addEditDataProviderMethod")
public void createTopic(String Header,String descriptions,String Series, String Topic_name) throws InterruptedException
{
	//System.out.println(Topic_name);
	createtopicpublish=createcourse.createCourse(Header,descriptions,Series);
	Assert.assertTrue(createtopicpublish.validateEle(), "invalid page");
	createtopicpublish.addCourse(Topic_name);

}
@DataProvider
public Object[][] addEditDataProviderMethod()
{
	Object[][] data = TestUtil.getTestData("Add_course");
	return data;
}

	@AfterSuite
	public void closure()
	{
		driver.quit();
	}
	
	
}
