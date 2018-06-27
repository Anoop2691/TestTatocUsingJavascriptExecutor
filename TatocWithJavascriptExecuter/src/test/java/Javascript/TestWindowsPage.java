package Javascript;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestWindowsPage {
	JavascriptExecutor jsDriver;
	public TestWindowsPage(JavascriptExecutor jsDriver) {
		this.jsDriver=jsDriver;
	}
	
	public void generatePopUpWindowAddTextAndProceed(WebDriver driver) throws InterruptedException {

		jsDriver.executeScript("document.querySelector('body > div > div.page > a:nth-child(4)').click()");
	     String parentWindow=driver.getWindowHandle();
	     String subWindow=null;
	     Set<String> handles=driver.getWindowHandles();
	     for(String h:handles) {
	    	 subWindow=h;
	     }	     
	     driver.switchTo().window(subWindow);
	     jsDriver.executeScript("document.getElementById('name').value='abc'");
	     jsDriver.executeScript("document.getElementById('submit').click()");
	     driver.switchTo().window(parentWindow); 
	     jsDriver.executeScript("document.querySelector('body > div > div.page > a:nth-child(6)').click()");
	     String response=(String) jsDriver.executeScript("return document.querySelector(\'.page>h1\').textContent");
			Assert.assertEquals(response,"Cookie Handling");
		
	}

}
