package pageObject;

import org.openqa.selenium.WebDriver;

public class Page {
	protected WebDriver driver = null;
	public void openPage (String pageURL) {
		
	        driver.get(pageURL);
	}
	  public Page (WebDriver driver) {
		    this.driver = driver;
		  }

}


