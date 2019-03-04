package assignment.mindtickle;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import mt.qa.base.TestBase;
import mt.qa.pages.ContentHomePage;
import mt.qa.pages.CreateNewCoursePage;
import mt.qa.pages.LoginPage;
import mt.qa.util.CustomeListeners;

@Listeners(CustomeListeners.class)
public class ContentHomePageTest extends TestBase
{
	
	LoginPage loginpage;
	ContentHomePage homepage;
	CreateNewCoursePage createcourse;
	
	@BeforeSuite
	public void setUp()
	{
		launchBrowser();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void validateHomePageTitle() 
	{
		String title = homepage.homePageTitle();
		Assert.assertEquals(title, "Content Home","Invalid Home Page title");
	}

	@Test(priority=2)
	public void openCreateNewCoursePage()
	{
		createcourse =homepage.createCourse();
		Assert.assertTrue(createcourse.validateEle(), "Invalid page");
	}
	
	@AfterSuite
	public void closure()
	{
		driver.quit();
	}
}
