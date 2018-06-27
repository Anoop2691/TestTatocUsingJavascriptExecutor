package Javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TatocTest {

	WebDriver driver;
	JavascriptExecutor jsDriver;
	private TestBasicCourseLinkPage TestBasicCourseLinkPage;
	private TestGridGatePage TestGridGatePage;
	private TestFrameDungeonPage TestFrameDungeonPage;
	private TestDragAroundPage TestTestDragAroundPagePage;
	private TestWindowsPage TestWindowsPage;
	private TestCookieHandlingPage TestCookieHandlingPage;

	@BeforeClass
	public void LaunchBrowser() {
		driver=new ChromeDriver();
		jsDriver = (JavascriptExecutor)driver;	
		jsDriver.executeScript("window.location='http://10.0.1.86/tatoc\'");
	}
	@Test
	public void Page1ClickOnBasicCourse() {
		TestBasicCourseLinkPage=new TestBasicCourseLinkPage(jsDriver);
		TestBasicCourseLinkPage.navigate_To_Basic();
	}
	@Test
	public void Page2ClickOnGreenGridInGridPage() {
		TestGridGatePage=new TestGridGatePage(jsDriver);
		TestGridGatePage.clickOnGreenBox();
	}
	@Test
	public void Page3ClickOnProceedWhenColorMatches() throws InterruptedException {
		TestFrameDungeonPage=new TestFrameDungeonPage(jsDriver);
		TestFrameDungeonPage.clickWhenSameColorComesInBothFrameBox();
	}
	
	@Test
	public void Page2ClickOnProceedWhenDragboxIsInDropbox() {
		TestTestDragAroundPagePage=new TestDragAroundPage(jsDriver);
		TestTestDragAroundPagePage.dragBoxIntoDropbox();
	}
	
	@Test
	public void Page5ClickOnproceedAfterEnteringTextInPopUpWindow() throws InterruptedException {
		TestWindowsPage=new TestWindowsPage(jsDriver);
		TestWindowsPage.generatePopUpWindowAddTextAndProceed(driver);
	}
	
	@Test
	public void Page6ClickOnProceedAfterGeneratingAndAddingCookie() {
		TestCookieHandlingPage =new TestCookieHandlingPage(jsDriver);
		TestCookieHandlingPage.creatingAndAddingCookie();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
