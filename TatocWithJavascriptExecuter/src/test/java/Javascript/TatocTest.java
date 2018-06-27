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
	public void Step_01_Click_on_Basic() {
		TestBasicCourseLinkPage=new TestBasicCourseLinkPage(jsDriver);
		TestBasicCourseLinkPage.navigate_To_Basic();
	}
	@Test
	public void Step_02_Grid_Gate() {
		TestGridGatePage=new TestGridGatePage(jsDriver);
		TestGridGatePage.greenBox();
	}
	@Test
	public void Step_03_Frame_Dungeon() throws InterruptedException {
		TestFrameDungeonPage=new TestFrameDungeonPage(jsDriver);
		TestFrameDungeonPage.sameColor();
	}
	
	@Test
	public void Step_04_Drag_Around() {
		TestTestDragAroundPagePage=new TestDragAroundPage(jsDriver);
		TestTestDragAroundPagePage.dragBox();
	}
	
	@Test
	public void Step_05_Pop_Up() throws InterruptedException {
		TestWindowsPage=new TestWindowsPage(jsDriver);
		TestWindowsPage.PopUpClick(driver);
	}
	
	@Test
	public void Step_06_TestCookieHandlingPage_page() {
		TestCookieHandlingPage =new TestCookieHandlingPage(jsDriver);
		TestCookieHandlingPage.creating_cookie();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
