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
public class CreateNewCourseTest extends TestBase
{
	LoginPage loginpage;
	ContentHomePage homepage;
	CreateNewCoursePage createcourse;
	CreateTopicAndPublishPage createtopicpublish;
	
	@BeforeSuite
	public void setUp()
	{
		launchBrowser();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		createcourse =homepage.createCourse();
	}

	@Test(priority=1)
	public void validateCreateNewCoursePage() 
	{
		String title = createcourse.createCoursePageheader();
		Assert.assertEquals(title, "Create New Course","Invalid create couser page header");
	}

	@Test(priority=2,dataProvider="dataProviderMethod")
	public void createNewCourse(String Header,String descriptions,String Series) throws InterruptedException
	{
		createtopicpublish=createcourse.createCourse(Header,descriptions,Series);
		Assert.assertTrue(createtopicpublish.validateEle(), "names are not matching");

	}
	
	@DataProvider
	public Object[][] dataProviderMethod()
	{
		Object[][] data = TestUtil.getTestData("Create_course");
		return data;
	}
	@AfterSuite
	public void closure()
	{
		driver.quit();
	}
	
	
}
