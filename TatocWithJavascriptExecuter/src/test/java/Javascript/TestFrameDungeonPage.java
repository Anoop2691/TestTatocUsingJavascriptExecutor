package Javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class TestFrameDungeonPage {

	JavascriptExecutor jsDriver;
	String FirstBoxcolor;
	String SecondBoxColor;
	public TestFrameDungeonPage(JavascriptExecutor jsDriver) {
		this.jsDriver=jsDriver;
	}
	
	public void clickWhenSameColorComesInBothFrameBox() throws InterruptedException {
	FirstBoxcolor=(String) jsDriver.executeScript("return document.getElementById(\"main\").contentWindow.document.getElementById(\"answer\").className");
	while(true){
	
		jsDriver.executeScript("document.getElementById(\"main\").contentWindow.document.querySelector(\'body > center:nth-child(1) > a:nth-child(7)\').click()");
		SecondBoxColor=(String) jsDriver.executeScript("return document.getElementById(\"main\").contentWindow.document.getElementById(\"child\").contentWindow.document.getElementById(\"answer\").className");
		
		if(FirstBoxcolor.equals(SecondBoxColor)) {
			jsDriver.executeScript("document.getElementById(\"main\").contentWindow.document.querySelector(\"body > center:nth-child(1) > a:nth-child(9)\").click()");
			String response=(String) jsDriver.executeScript("return document.querySelector(\'.page>h1\').textContent");
			Assert.assertEquals(response,"Drag Around");
			break;
				}
			}
		}
}
