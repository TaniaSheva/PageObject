package pageObject;

import org.openqa.selenium.WebDriver;

public class Page {
	public WebDriver driver = SortOut.driver;
	public void openPage (String pageURL) {
		
	        driver.get(pageURL);
	}

}
