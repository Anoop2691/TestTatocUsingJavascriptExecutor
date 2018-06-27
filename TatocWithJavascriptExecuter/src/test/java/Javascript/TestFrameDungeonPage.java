package Javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class TestFrameDungeonPage {

	JavascriptExecutor jsDriver;
	String qcolor;
	String acolor;
	public TestFrameDungeonPage(JavascriptExecutor jsDriver) {
		this.jsDriver=jsDriver;
	}
	
	public void sameColor() throws InterruptedException {
	qcolor=(String) jsDriver.executeScript("return document.getElementById(\"main\").contentWindow.document.getElementById(\"answer\").className");
	System.out.println(qcolor);
	while(true){
	
		jsDriver.executeScript("document.getElementById(\"main\").contentWindow.document.querySelector(\'body > center:nth-child(1) > a:nth-child(7)\').click()");
		acolor=(String) jsDriver.executeScript("return document.getElementById(\"main\").contentWindow.document.getElementById(\"child\").contentWindow.document.getElementById(\"answer\").className");
		
		if(qcolor.equals(acolor)) {
			jsDriver.executeScript("document.getElementById(\"main\").contentWindow.document.querySelector(\"body > center:nth-child(1) > a:nth-child(9)\").click()");
			String response=(String) jsDriver.executeScript("return document.querySelector(\'.page>h1\').textContent");
			Assert.assertEquals(response,"Drag Around");
			System.out.println("Frame dungeon executed successfully");
			break;
				}
			}
		}
}
