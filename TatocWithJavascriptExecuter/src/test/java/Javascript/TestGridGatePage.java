package Javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class TestGridGatePage {

	JavascriptExecutor jsDriver;
	
	public TestGridGatePage(JavascriptExecutor jsDriver) {
		this.jsDriver=jsDriver;
	}
	
	public void clickOnGreenBox() {
		jsDriver.executeScript("document.getElementsByClassName(\'greenbox\')[0].click();");
		String response=(String) jsDriver.executeScript("return document.querySelector(\'.page>h1\').textContent");
		Assert.assertEquals(response, "Frame Dungeon");
	}
}
