package pageObject;

import org.openqa.selenium.WebDriver;

public class Page {
	public WebDriver driver;
	public void openPage (String PageURL) {
	        driver.get(PageURL);
	}

}
