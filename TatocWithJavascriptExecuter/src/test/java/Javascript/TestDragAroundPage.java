package Javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class TestDragAroundPage {
	JavascriptExecutor jsDriver;
	public TestDragAroundPage(JavascriptExecutor jsDriver) {
		this.jsDriver=jsDriver;
	}
	public void dragBoxIntoDropbox() {
		jsDriver.executeScript("document.getElementById(\"dragbox\").setAttribute(\"style\",\"position: relative; left: 40px; top: -66px;\")");
		jsDriver.executeScript("document.querySelector(\".page > a:nth-child(10)\").click()");
		String response=(String) jsDriver.executeScript("return document.querySelector(\'.page>h1\').textContent");
		Assert.assertEquals(response,"Popup Windows");
	}

}
